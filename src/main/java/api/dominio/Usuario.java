package api.dominio;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(name = "usuario_nombre")
    private String nombre; // TODO: CAMBIAR A MAIL
    @Column(name = "usuario_password")
    private String password;
    @Column(name = "usuario_is_admin")
    private Boolean isAdmin;


    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.isAdmin = false;
    }

    public Usuario() {
    }

    public Long getUsuario_id() {
        return usuarioId;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuarioId = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
