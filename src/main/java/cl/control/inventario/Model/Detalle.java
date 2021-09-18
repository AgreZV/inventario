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
}
