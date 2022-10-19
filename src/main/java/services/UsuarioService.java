package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dominio.Persona;
import dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.RepoPersona;
import repositorios.RepoUsuario;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService {
    private final RepoUsuario repoUsuarios;
    private final RepoPersona repoPersonas;

    @Autowired
    public UsuarioService(RepoUsuario repoUsuario, RepoPersona repoPersona) {
        this.repoUsuarios = repoUsuario;
        this.repoPersonas = repoPersona;
    }

    public Usuario obtenerUsuario(Long uId) {
        this.validarIdUsuario(uId);
        return repoUsuarios.findUsuarioByUsuario_id(uId);
    }

    public void registrar(Persona p) throws IOException {
        if(this.validarRegistro(p)) {
            this.agregarUsuario(p);
            this.agregarPersona(p);
        }
    }

    private void agregarUsuario(Persona p) {
        Usuario u = new Usuario(p.getNombre().charAt(0) + "." + p.getApellido(), p.getApellido());
        u.setUsuario_id(repoUsuarios.count() + 1);

        repoUsuarios.save(u);
    }

    private void agregarPersona(Persona p) {
        Persona person = new Persona(p.getDni(), p.getNombre(), p.getApellido());

        person.setId(repoPersonas.count() + 1);
        person.setUsuario(repoUsuarios.getById(repoUsuarios.count()));

        repoPersonas.save(person);
    }

    public Boolean logear(Usuario u) {
        if(!this.validarInicioSesion(u))
            return false;
        Usuario auxU = repoUsuarios.findUsuarioByNombre(u.getNombre());
        return Objects.equals(auxU.getPassword(), u.getPassword());
    }


    private void validarIdUsuario(Long id) {
        if(id <= 0)
            System.out.println("ID " + id + " invalido");

        if(!repoUsuarios.existsById(id))
            System.out.println("No existe un usuario con ID " + id);
    }

    private Boolean validarRegistro(Persona per) throws IOException { //la persona tiene que estar en la lista y no estar registrada
        List<Persona> personas = this.getPersonsFromJSON();

        Boolean esPersonaAutorizada = personas.stream().anyMatch(p -> Objects.equals(p.getDni(), per.getDni()) && Objects.equals(p.getNombre(), per.getNombre()) && Objects.equals(p.getApellido(), per.getApellido())); //si la persona esta en la lista (en el json)
        Boolean yaRegistrada = repoUsuarios.existsUsuarioByNombre(per.getNombre().charAt(0) + per.getApellido()); //si la persona ya esta registrada (guardamos los usuarios con la primera letra del nombre y el apellido tipo dingratta)

        return esPersonaAutorizada && !yaRegistrada;
    }

    private List<Persona> getPersonsFromJSON() throws IOException { //obtiene la lista de personas del json
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/resources/personas.json"), new TypeReference<>() {
        });
    }

    private Boolean validarInicioSesion(Usuario user) {
        return repoUsuarios.existsUsuarioByNombre(user.getNombre());
    }

}
