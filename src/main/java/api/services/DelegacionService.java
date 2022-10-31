package api.services;

import api.controllers.SesionManager;
import api.dominio.Delegacion;
import api.dominio.EstadoDelegacion;
import api.dominio.Persona;
import api.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.repositorios.RepoDelegacion;
import api.repositorios.RepoPersona;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class DelegacionService {
    @Autowired
    private final RepoDelegacion repoDelegacion;
    @Autowired
    private final RepoPersona repoPersonas;

    public DelegacionService(RepoDelegacion delegationRepository, RepoPersona personRepository) {
        this.repoDelegacion = delegationRepository;
        this.repoPersonas = personRepository;
    }

    public Delegacion getDelegacionByDelegacion_id(Long idDelegation) {
        return repoDelegacion.findByDelegacionId(idDelegation);
    }

    public List<Delegacion> obtenerDelegacionesEnEspera(String sesionUsuario){
        /*
            cuando una persona quiere aceptar o rechazar una delegacion,
            ella toma el rol de delegado (ya que es la otra persona es el delegador, quien la esta invitando a la delegacion)
        */
        SesionManager sesionManager = SesionManager.get();
        Map<String, Object> elementoHashMap = sesionManager.obtenerAtributos(sesionUsuario);
        Usuario usuario = (Usuario) elementoHashMap.get("usuario");
        Persona personaDelegada = repoPersonas.findPersonaByUsuario_Nombre(usuario.getNombre());
        List<Delegacion> delegacionesEnEspera = repoDelegacion.findByDelegado_IdAndEstado(personaDelegada.getId(), EstadoDelegacion.ESPERA);
        System.out.println("Delegaciones en espera: " + delegacionesEnEspera);
        return delegacionesEnEspera;
    }

    @Transactional
    public void realizarDelegacion(String sesionUsuario, String dniDelegado){
        SesionManager sesionManager = SesionManager.get();
        Map<String, Object> elementoHashMap = sesionManager.obtenerAtributos(sesionUsuario);
        Usuario usuarioDelegador = (Usuario) elementoHashMap.get("usuario");
        Persona personaDelegador = repoPersonas.findPersonaByUsuario_Nombre(usuarioDelegador.getNombre());
        Persona personaDelegado = repoPersonas.findPersonaByDni(dniDelegado);

        Delegacion delegacion = new Delegacion(personaDelegado, personaDelegador) ;
        repoDelegacion.save(delegacion);
    }

    @Transactional
    public boolean aceptarDelegacion(Long delegationId){
        Delegacion delegacion = this.getDelegacionByDelegacion_id(delegationId);
        delegacion.setEstado(EstadoDelegacion.ACEPTADA);
        try {
            repoDelegacion.save(delegacion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean rechazarDelegacion(Long delegationId){
        Delegacion delegacion = this.getDelegacionByDelegacion_id(delegationId);
        try {
            repoDelegacion.delete(delegacion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Delegacion> reporteDelegaciones(String usuarioSesion){
        SesionManager sesionManager = SesionManager.get();
        Map<String, Object> elementoHashMap = sesionManager.obtenerAtributos(usuarioSesion);
        Usuario usuario = (Usuario) elementoHashMap.get("usuario");
        System.out.println(usuario.getAdmin());
        if(usuario.getAdmin()){
            return repoDelegacion.findAll();
        }
        return new ArrayList<Delegacion>(); // TODO: REVISAR ACA
    }
}