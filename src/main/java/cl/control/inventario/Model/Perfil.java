package cl.control.inventario.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Información o propiedades de los perfiles")
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column(name = "idPerfil")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPerfil;

    @ApiModelProperty(notes = "nombre del perfil no debe ser mayor a 50 caracteres")
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
