package cl.control.inventario;

import cl.control.inventario.Model.Usuario;
import cl.control.inventario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //usuario: admin
        //clave: 123
        //return new User("admin", "$2y$12$a0OOMjc8bg0F2hjoD91S.eCg4N/98KPSr4Bp3wkR5ykSkyeDdg4tK", new ArrayList<>());
        Usuario usuario = usuarioService.findOneByNombre(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario " + username + " no existe");
        }
        return new User(usuario.getNombre(), usuario.getPassword(), new ArrayList<>());
    }

}
