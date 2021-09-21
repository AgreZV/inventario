package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.Estado;
import cl.control.inventario.Repository.EstadoRepository;
import cl.control.inventario.Service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    @Override
    public Estado findById(Integer id) {
        Optional<Estado> user = estadoRepository.findById(id);
        return user.isPresent() ? user.get() : new Estado();
    }

    @Override
    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public Estado update(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Estado> optionalEstado = estadoRepository.findById(id);
        if(!optionalEstado.isPresent()){
            throw new Exception("ID: " + id + " DE ESTADO NO ENCONTRADO");
        }
        estadoRepository.deleteById(id);
        return true;
    }
}
