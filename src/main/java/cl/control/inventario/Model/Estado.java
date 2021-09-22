package cl.control.inventario.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Información del estado del usuario")
@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @Column(name = "idEstado")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idEstado;

    @ApiModelProperty(notes = "estado de usuario no debe ser mayor a 15 caracteres")
    @Column(name = "descripcion", length = 15)
    private String descripcion;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}