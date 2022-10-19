package repositorios;

import dominio.Delegacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDelegacion extends JpaRepository<Delegacion, Long> {
    Delegacion findDelegacionByDelegacion_id(Long idDelegacion);

    Delegacion deleteByDelegacion_id(Long idDelegacion);
}
