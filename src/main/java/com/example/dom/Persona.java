package com.example.dom;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Integer id;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "delegado", cascade = CascadeType.ALL)//ver esto!
    private List<Delegacion> delegaciones;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "")
    private Usuario usuario;
}
