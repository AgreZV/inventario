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



}
