package api.repositorios;

import api.dominio.Persona;
import api.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPersona extends JpaRepository<Persona, Long> {
    Persona findPersonaById(Long pId);
    Persona findPersonaByDni(String dni);
    Persona findPersonaByUsuario(Usuario usuario);
}
