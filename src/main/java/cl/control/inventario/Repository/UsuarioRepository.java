package cl.control.inventario.Repository;

import cl.control.inventario.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //select * from usuario where username = ?
    public Usuario findOneByUsername(String username);
 }
