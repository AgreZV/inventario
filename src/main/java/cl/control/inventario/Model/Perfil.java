package cl.control.inventario.Model;

import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column(name = "idPerfil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerfil;

    @Column(name = "nombre", length = 50)
    private String nombre;

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
