package cl.control.inventario.Model;

import javax.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @Column(name = "idProveedor")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProveedor;

    @Column(name = "razonSocial")
    private String razonSocial;

    @Column(name = "rutProveedor")
    private String rutProveedor;

    @Column(name = "direccionProveedor")
    private String direccionProveedor;

    @Column(name = "telefonoProveedor")
    private String telefonoProveedor;

    @Column(name = "correoProveedor")
    private String correoProveedor;

}
