package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.Proveedor;
import cl.control.inventario.Repository.ProveedorRepository;
import cl.control.inventario.Service.ProveedorService;
import cl.control.inventario.exception.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor findById(Integer id) throws Exception {
        Optional<Proveedor> prov = proveedorRepository.findById(id);
        if (!prov.isPresent()) {
            throw new ModeloNotFoundException("Proveedor no encontrado con id: " + id);
        }else{
            return prov.get();
        }
    }

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor update(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Proveedor> optionalProveedor = proveedorRepository.findById(id);
        if(!optionalProveedor.isPresent()){
            throw new Exception("ID: " + id + " DE PROVEEDOR NO ENCONTRADO");
        }
        proveedorRepository.deleteById(id);
        return true;
    }
}
