package cl.control.inventario.Controller;

import cl.control.inventario.Model.Proveedor;
import cl.control.inventario.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> findAll(){
        return proveedorService.findAll();
    }

    @GetMapping("/{id}")
    public Proveedor findById(@PathVariable("id") Integer id) throws Exception {
        return proveedorService.findById(id);
    }

    @PostMapping
    public Proveedor save(@RequestBody Proveedor proveedor){
        return proveedorService.save(proveedor);
    }

    @PutMapping
    public Proveedor update(@RequestBody Proveedor proveedor){
        return proveedorService.update(proveedor);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        proveedorService.deleteById(id);
        return "proveedor eliminado correctamente";
    }


}
