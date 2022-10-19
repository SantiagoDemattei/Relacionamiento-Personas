package repositorios;

import dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByUsuario_id(Long idUser);
    Usuario findUsuarioByNombre(String u);

    Boolean existsUsuarioByNombre(String u);
}
