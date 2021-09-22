package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.Usuario;
import cl.control.inventario.Repository.UsuarioRepository;
import cl.control.inventario.Service.UsuarioService;
import cl.control.inventario.exception.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> user = usuarioRepository.findById(id);
        if (!user.isPresent()) {
            throw new ModeloNotFoundException("Usuario no encontrado con id: " + id);
        }else{
            return user.get();
        }
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(!optionalUsuario.isPresent()){
            throw new Exception("ID: " + id + " DE USUARIO NO ENCONTRADO");
        }
        usuarioRepository.deleteById(id);
        return true;
    }
}
