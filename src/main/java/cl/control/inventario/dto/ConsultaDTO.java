package cl.control.inventario.dto;

import cl.control.inventario.Model.Producto;
import cl.control.inventario.Model.Proveedor;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.List;

public class ConsultaDTO extends ResourceSupport implements Serializable {

    private Proveedor proveedor;
    private List<Producto> listaProductos;

    public ConsultaDTO(Proveedor proveedor, List<Producto> listaProductos) {
        this.proveedor = proveedor;
        this.listaProductos = listaProductos;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
