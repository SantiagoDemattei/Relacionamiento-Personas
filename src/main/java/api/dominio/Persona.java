package api.dominio;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    @JsonIgnore
    private Long id;

    @Column(name = "persona_nombre")
    private String nombre;
    @Column(name = "persona_apellido")
    private String apellido;
    @Column(name = "persona_dni")
    private String dni;

    @Column(name = "persona_fechaNacimiento")
    private  String fechaNacimiento;

    @Column(name = "persona_ciudad")
    private String ciudad;

    @Column(name = "persona_localidad")
    private String localidad;

    @Column(name = "persona_foto")
    private String foto;

    @JsonProperty("usuario")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "persona_id_usuario")
    private Usuario usuario;

    public Persona(String dni, String nombre, String apellido) {
    }

    public Persona() {
    }

    private void aceptarDelegacion(Delegacion d) {
        d.setEstado(EstadoDelegacion.ACEPTADA);
    }


    //Setters y Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
