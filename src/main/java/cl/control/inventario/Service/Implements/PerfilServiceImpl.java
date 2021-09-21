package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.Perfil;
import cl.control.inventario.Repository.PerfilRepository;
import cl.control.inventario.Service.PerfilService;
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
        Optional<Perfil> perfil0 = perfilRepository.findById(id);
        return perfil0.isPresent() ? perfil0.get() : new Perfil();
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
