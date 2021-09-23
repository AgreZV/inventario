package cl.control.inventario.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@ApiModel(description = "Información o propiedades de los productos")
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "idProducto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idProducto;

    @ApiModelProperty(notes = "Nombre del producto debe ser ingresado")
    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "marca")
    private String marca;

    @ApiModelProperty(notes = "precio de compra debe ser mayor que cero")
    @Positive
    @Column(name = "precioCompra")
    private Double precioCompra;

    @ApiModelProperty(notes = "precio de venta debe ser mayor que cero")
    @Positive
    @Column(name = "precioVenta")
    private Double precioVenta;

    @ApiModelProperty(notes = "cantidad minima no debe ser menor que cero")
    @PositiveOrZero
    @Column(name = "cantidadMinima")
    private Integer cantidadMinima;

    @ApiModelProperty(notes = "cantidad actual del producto no debe ser menor que cero")
    @PositiveOrZero
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
    private Proveedor proveedor;


 /*   @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id_usuario")
    private Usuario user;*/

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idDetalle", referencedColumnName = "idDetalle")
    private Detalle detalle;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
