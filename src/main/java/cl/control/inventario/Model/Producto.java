package cl.control.inventario.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "idProducto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "precioCompra")
    private Double precioCompra;

    @Column(name = "precioVenta")
    private Double precioVenta;

    @Column(name = "cantidadMinima")
    private Integer cantidadMinima;

    @Column(name = "cantidadActual")
    private Integer cantidadActual;

    @Column(name = "codigo")
    private String codigo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "productoSucursal",
            joinColumns = @JoinColumn(name = "idProducto", referencedColumnName = "idProducto"),
            inverseJoinColumns = @JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal"))
    private List<Sucursal> sucursales;

    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_proveedor"))
    private Estado estado;

 /*   @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario user;*/

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idDetalle", referencedColumnName = "idDetalle")
    private Detalle detalle;

}
