package repositorios;

import dominio.Persona;
//mport com.grupo2.relacionamientopersonas.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPersona extends JpaRepository<Persona, Long> {
    Persona findPersonaById(Long pId);
    Persona findPersonaByDni(Long dni);

}
