package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.Estado;
import cl.control.inventario.Repository.EstadoRepository;
import cl.control.inventario.Service.EstadoService;
import cl.control.inventario.exception.ModeloNotFoundException;
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
        Optional<Estado> est = estadoRepository.findById(id);
        if (!est.isPresent()) {
            throw new ModeloNotFoundException("Estado no encontrado con id: " + id);
        }else{
            return est.get();
        }
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
