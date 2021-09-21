package cl.control.inventario.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "rut", length = 12)
    private String rut;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "password")
    private String password;

    @Column(name = "correo")
    private String correo;

    @ManyToOne
    @JoinColumn(name = "idEstado", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_estado"))
    private Estado estado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarioPerfil",
            joinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil"))
    private List<Perfil> perfiles;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
}
