package api.repositorios;

import api.dominio.Delegacion;
import api.dominio.EstadoDelegacion;
import api.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoDelegacion extends JpaRepository<Delegacion, Long> {
    Delegacion findByDelegacionId(Long idDelegacion);
    List<Delegacion> findByDelegado_IdAndEstado(Long id, EstadoDelegacion estado);
    void deleteByDelegacionId(Long idDelegacion);
}
