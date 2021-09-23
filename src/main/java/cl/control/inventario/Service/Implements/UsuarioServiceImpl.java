package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.Usuario;
import cl.control.inventario.Repository.UsuarioRepository;
import cl.control.inventario.Service.UsuarioService;
import cl.control.inventario.exception.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByUsername(username);
        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }
        List<GrantedAuthority> perfiles = new ArrayList<>();
        //usuario.getRols().forEach(rol -> {
        usuario.getPerfiles().forEach(perfil -> {
            perfiles.add(new SimpleGrantedAuthority(perfil.getNombre()));
        });
        UserDetails ud = new User(usuario.getNombre(), usuario.getPassword(), perfiles);
        return ud;
    }

    @Override
    public Usuario findOneByUsername(String username) {
        return usuarioRepository.findOneByUsername(username);
    }

}
