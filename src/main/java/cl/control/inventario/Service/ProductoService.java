package cl.control.inventario.Service;

import cl.control.inventario.Model.Producto;

import java.util.List;

public interface ProductoService extends ICRUD<Producto> {
    public List<Producto> findAllByProveedor(Integer idProveedor);
}
