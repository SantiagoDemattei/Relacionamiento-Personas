package com.example.dom;

import javax.persistence.*;

@Entity
@Table(name = "delegacion")
public class Delegacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delegacion_id")
    private Integer delegacion_id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = ".")
    private Persona delegado;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = ".")
    private Persona delegador;
}
