package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.Perfil;
import cl.control.inventario.Repository.PerfilRepository;
import cl.control.inventario.Service.PerfilService;
import cl.control.inventario.exception.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public Perfil findById(Integer id) throws Exception {
        Optional<Perfil> opt = perfilRepository.findById(id);
        if (!opt.isPresent()) {
            throw new ModeloNotFoundException("Perfil no encontrado con id: " + id);
        }else{
            return opt.get();
        }
    }

    @Override
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil update(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Perfil> optionalPerfil = perfilRepository.findById(id);
        if(!optionalPerfil.isPresent()){
            throw new Exception("ID: " + id + " DE PERFIL NO ENCONTRADO");
        }
        perfilRepository.deleteById(id);
        return true;
    }
}
