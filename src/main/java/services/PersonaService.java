package services;

import dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.RepoPersona;

import javax.transaction.Transactional;

@Service
public class PersonaService {
    private final RepoPersona repoPersona;

    @Autowired
    public PersonaService(RepoPersona repoPersona) {
        this.repoPersona = repoPersona;
    }

    public Persona obtenerPersona(Long pId){
        this.validarPersonaId(pId);

        return repoPersona.findPersonaById(pId);
    }

    @Transactional
    public void actualizarPersona(Persona p) {
        this.validarPersonaId(p.getId());

        Persona person = this.obtenerPersona(p.getId());
        person.setCiudad(p.getCiudad());
        person.setLocalidad(p.getLocalidad());
        person.setFechaNacimiento(p.getFechaNacimiento());
        person.setFoto(p.getFoto());
    }

    private void validarPersonaId(Long id) {
        if(id <= 0)
            System.out.println("ID " + id + " invalido");

        if(!repoPersona.existsById(id))
            System.out.println("No existe una persona con ID " + id);
    }

}