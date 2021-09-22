package cl.control.inventario.Service.Implements;

import cl.control.inventario.Model.Producto;
import cl.control.inventario.Repository.ProductoRepository;
import cl.control.inventario.Service.ProductoService;
import cl.control.inventario.exception.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto findById(Integer id) throws Exception {
        Optional<Producto> pro = productoRepository.findById(id);
        if (!pro.isPresent()) {
            throw new ModeloNotFoundException("Producto no encontrado con id: " + id);
        }else{
            return pro.get();
        }
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        Optional<Producto> optionalProveedor = productoRepository.findById(id);
        if(!optionalProveedor.isPresent()){
            throw new Exception("ID: " + id + " DE PRODUCTO NO ENCONTRADO");
        }
        productoRepository.deleteById(id);
        return true;
    }
}
