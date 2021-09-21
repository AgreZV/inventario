package cl.control.inventario.Controller;

import cl.control.inventario.Model.Sucursal;
import cl.control.inventario.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> findAll(){
        return sucursalService.findAll();
    }

    @GetMapping("/{id}")
    public Sucursal findById(@PathVariable("id") Integer id) throws Exception {
        return sucursalService.findById(id);
    }

    @PostMapping
    public Sucursal save(@RequestBody Sucursal sucursal){
        return sucursalService.save(sucursal);
    }

    @PutMapping
    public Sucursal update(@RequestBody Sucursal sucursal){
        return sucursalService.update(sucursal);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        sucursalService.deleteById(id);
        return "sucursal eliminado correctamente";
    }

}
