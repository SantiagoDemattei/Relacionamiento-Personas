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
        Map<String, Object> elementoHashMap = sesionManager.obtenerAtributos(sesionUsuario); // TODO: ESTA ROMPIENDO ACA (ENCUENTRA null)
        Usuario usuario = (Usuario) elementoHashMap.get("usuario");
        Persona personaActual = repoPersona.findPersonaByUsuario(usuario); // TODO: REVISAR ESTO

        personaActual.setCiudad(p.getCiudad());
        personaActual.setLocalidad(p.getLocalidad());
        personaActual.setFechaNacimiento(p.getFechaNacimiento());
        personaActual.setFoto(p.getFoto());
    }

}