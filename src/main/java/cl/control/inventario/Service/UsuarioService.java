package cl.control.inventario.Service;

import cl.control.inventario.Model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();

    Usuario findById(Integer id);

    Usuario save(Usuario usuario);

    Usuario update(Usuario usuario);

    Usuario deleteById(Integer id);
}

