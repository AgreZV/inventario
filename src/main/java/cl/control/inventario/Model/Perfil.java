package cl.control.inventario.Model;

import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column(name = "idPerfil")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPerfil;

    @Column(name = "nombre", length = 50)
    private String nombre;
}
