package cl.control.inventario.Model;

import javax.persistence.*;

@Entity
@Table(name = "detalle")
public class Detalle {

    @Id
    @Column(name = "idDetalle")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idDetalle;

    @Column(name = "estado")
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "color")
    private String color;

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
