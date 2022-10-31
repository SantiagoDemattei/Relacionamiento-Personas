package api.dominio;

import javax.persistence.*;

@Entity
@Table(name = "delegacion")
public class Delegacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delegacion_id")
    private Long delegacionId;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "delegacion_delegado")
    private Persona delegado;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "delegacion_delegador")
    private Persona delegador;

    @Column(name = "delegacion_estado")
    @Enumerated(EnumType.STRING)
    private EstadoDelegacion estado;

    public Delegacion(Persona p1, Persona p2) {
        this.delegado = p1;
        this.delegador = p2;
        this.estado = EstadoDelegacion.ESPERA;
    }

    public Delegacion() {

    }

    public void setEstado(EstadoDelegacion estado) {
        this.estado = estado;
    }

    public Long getDelegacion_id() {
        return delegacionId;
    }

    public void setDelegacion_id(Long delegacion_id) {
        this.delegacionId = delegacion_id;
    }

    public Persona getDelegado() {
        return delegado;
    }

    public void setDelegado(Persona delegado) {
        this.delegado = delegado;
    }

    public Persona getDelegador() {
        return delegador;
    }

    public void setDelegador(Persona delegador) {
        this.delegador = delegador;
    }

    public EstadoDelegacion getEstado() {
        return estado;
    }
}
