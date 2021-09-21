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

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }
}
