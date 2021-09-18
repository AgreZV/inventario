package cl.control.inventario.Controller;

import cl.control.inventario.Model.Perfil;
import cl.control.inventario.Service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> findAll(){
        return perfilService.findAll();
    }

    @GetMapping("/{id}")
    public Perfil findById(@PathVariable("id") Integer id) throws Exception {
        return perfilService.findById(id);
    }

    @PostMapping
    public Perfil save(@RequestBody Perfil perfil){
        return perfilService.save(perfil);
    }

    @PutMapping
    public Perfil update(@RequestBody Perfil perfil){
        return perfilService.update(perfil);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        perfilService.deleteById(id);
        return "perfil eliminado correctamente";
    }
}
