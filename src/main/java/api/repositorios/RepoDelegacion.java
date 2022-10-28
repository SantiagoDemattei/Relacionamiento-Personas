package api.repositorios;

import api.dominio.Delegacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDelegacion extends JpaRepository<Delegacion, Long> {
    Delegacion findByDelegacionId(Long idDelegacion);

    void deleteByDelegacionId(Long idDelegacion);
}
