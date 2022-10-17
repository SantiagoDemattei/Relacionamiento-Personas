package com.example.dom;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuario_id;
    @Column(name = "usuario_nombre")
    private String nombre;
    @Column(name = "usuario_password")
    private String password;
    @Column(name = "usuario_isAdmin")
    private Boolean isAdmin;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval = true)
    @JoinColumn(name = "persona_id")
    private Persona persona;
}
