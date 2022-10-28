package api.repositorios;

import api.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByUsuarioId(Long idUser);
    Usuario findUsuarioByNombre(String u);

    Boolean existsUsuarioByNombre(String u);
}
