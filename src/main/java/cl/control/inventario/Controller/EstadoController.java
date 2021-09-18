package cl.control.inventario.Controller;

import cl.control.inventario.Model.Estado;
import cl.control.inventario.Service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> findAll(){
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public Estado findById(@PathVariable("id") Integer id) throws Exception {
        return estadoService.findById(id);
    }

    @PostMapping
    public Estado save(@RequestBody Estado estado){
        return estadoService.save(estado);
    }

    @PutMapping
    public Estado update(@RequestBody Estado estado){
        return estadoService.update(estado);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        estadoService.deleteById(id);
        return "estado eliminado correctamente";
    }
}
