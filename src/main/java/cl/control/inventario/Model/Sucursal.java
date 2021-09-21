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

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCorreoSucursal() {
        return correoSucursal;
    }

    public void setCorreoSucursal(String correoSucursal) {
        this.correoSucursal = correoSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
