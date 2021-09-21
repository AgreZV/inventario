package cl.control.inventario.Service;

import cl.control.inventario.Model.Sucursal;
import cl.control.inventario.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public Sucursal findById(Integer id) throws Exception {
        Optional<Sucursal> sucursal0 = sucursalRepository.findById(id);
        return sucursal0.isPresent() ? sucursal0.get() : new Sucursal();
    }

    @Override
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal update(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        if(!optionalSucursal.isPresent()){
            throw new Exception("ID: " + id + " DE SUCURSAL NO ENCONTRADO");
        }
        sucursalRepository.deleteById(id);
        return true;
    }
}
