package cl.control.inventario.Service;

import cl.control.inventario.Model.Usuario;

public interface UsuarioService extends ICRUD<Usuario>{
    public Usuario findOneByUsername(String username);
}

