package cl.control.inventario.Controller;

import cl.control.inventario.Model.Perfil;
import cl.control.inventario.Service.PerfilService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @ApiOperation(value = "Obtener el listado de Perfiles",
            notes = "no requiere parametros de entrada",
            response = List.class,
            responseContainer = "ListPerfiles")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrados"),
            @ApiResponse(code = 405, message = "No se encontraron usuarios en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public List<Perfil> findAll(){
        return perfilService.findAll();
    }

    @ApiOperation(value = "Buscar un Perfil por identificador",
            notes = "Se debe pasar el id del modelo Perfil",
            response = Perfil.class,
            responseContainer = "Perfil")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/{id}")
    public Perfil findById(@PathVariable("id") Integer id) throws Exception {
        return perfilService.findById(id);
    }

    @ApiOperation(value = "Ingresar un Perfil",
            notes = "Se debe pasar el objeto del Perfil Usuario",
            response = Perfil.class,
            responseContainer = "Perfil")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Perfil save(@RequestBody Perfil perfil){
        return perfilService.save(perfil);
    }

    @ApiOperation(value = "Actualizar un Perfil",
            notes = "Se debe pasar el objeto del modelo Perfil a modificar",
            response = Perfil.class,
            responseContainer = "Perfil")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Perfil update(@RequestBody Perfil perfil){
        return perfilService.update(perfil);
    }


    @ApiOperation(value = "Eliminar un Perfil",
            notes = "Se debe pasar el id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "Borrado OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        perfilService.deleteById(id);
        return "perfil eliminado correctamente";
    }
}
