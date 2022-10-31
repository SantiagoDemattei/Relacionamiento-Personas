package api.services;

import api.controllers.SesionManager;
import api.dominio.Persona;
import api.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import api.repositorios.RepoPersona;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonaService {
    @Autowired
    private final RepoPersona repoPersona;

    public PersonaService(RepoPersona repoPersona) {
        this.repoPersona = repoPersona;
    }


    @Transactional
    public void actualizarPersona(String sesionUsuario, Persona p) {
        SesionManager sesionManager = SesionManager.get();
        Map<String, Object> elementoHashMap = sesionManager.obtenerAtributos(sesionUsuario);
        Usuario usuario = (Usuario) elementoHashMap.get("usuario");
        Persona personaActual = repoPersona.findPersonaByUsuario_Nombre(usuario.getNombre());

        personaActual.setCiudad(p.getCiudad());
        personaActual.setLocalidad(p.getLocalidad());
        personaActual.setFechaNacimiento(p.getFechaNacimiento());
        personaActual.setFoto(p.getFoto());
    }

    public List<Persona> reportePersonas(String usuarioSesion){
        SesionManager sesionManager = SesionManager.get();
        Map<String, Object> elementoHashMap = sesionManager.obtenerAtributos(usuarioSesion);
        Usuario usuario = (Usuario) elementoHashMap.get("usuario");
        if(usuario.getAdmin()){
            return repoPersona.findAll();
        }
        return new ArrayList<Persona>(); // TODO: REVISAR ACA
    }

}