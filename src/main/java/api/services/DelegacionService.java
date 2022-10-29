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
        this.validarIdDelegacion(idDelegation);
        return repoDelegacion.findByDelegacionId(idDelegation);
    }

    @Transactional
    public void realizarDelegacion(String sesionUsuario, String dniDelegado){
        SesionManager sesionManager = SesionManager.get();
        Map<String, Object> elementoHashMap = sesionManager.obtenerAtributos(sesionUsuario);
        Usuario usuarioDelegador = (Usuario) elementoHashMap.get("usuario");
        Persona personaDelegador = repoPersonas.findPersonaByUsuario(usuarioDelegador);
        Persona personaDelegado = repoPersonas.findPersonaByDni(dniDelegado);

        Delegacion delegacion = new Delegacion(personaDelegado, personaDelegador) ;
        personaDelegado.addDelegadoDelegacion(delegacion);
        personaDelegador.addDelegadorDelegacion(delegacion);

        repoDelegacion.save(delegacion);
    }



    @Transactional
    public void delegationAcceptance(Long delegacionId, Boolean rtaDelegacion) {
        if(rtaDelegacion)
            this.getDelegacionByDelegacion_id(delegacionId).setEstado(EstadoDelegacion.ACEPTADA);
        else
            this.getDelegacionByDelegacion_id(delegacionId).setEstado(EstadoDelegacion.RECHAZADA);
    }

    public void delegationAuthorizationRevoke(Long idDelegacion) {
        repoDelegacion.deleteByDelegacionId(idDelegacion);
    }

    private void validarIdDelegacion(Long id) {
        if(id <= 0)
            System.out.println("ID " + id + " invalido");

        if(!repoDelegacion.existsById(id))
            System.out.println("No existe una delegacion con ID " + id);

    }
}