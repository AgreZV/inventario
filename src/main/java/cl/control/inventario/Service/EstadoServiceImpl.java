package cl.control.inventario.Service;

import cl.control.inventario.Model.Estado;
import cl.control.inventario.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    @Override
    public Estado findById(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Estado> findAll() {
        return null;
    }

    @Override
    public Estado save(Estado estado) {
        return null;
    }

    @Override
    public Estado update(Estado estado) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        return false;
    }
}
