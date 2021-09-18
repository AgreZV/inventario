package cl.control.inventario.Model;

import javax.persistence.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @Column(name = "idSucursal")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idSucursal;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "correoSucursal")
    private String correoSucursal;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

}
