package cl.control.inventario.Model;

import javax.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @Column(name = "idEstado")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idEstado;

    @Column(name = "descripcion", length = 15)
    private String descripcion;

}