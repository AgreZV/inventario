package cl.control.inventario.Controller;

import cl.control.inventario.Model.Estado;
import cl.control.inventario.Service.EstadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @ApiOperation(value = "Obtener el listado de Estados",
            notes = "no requiere parametros de entrada",
            response = List.class,
            responseContainer = "ListEstados")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrados"),
            @ApiResponse(code = 405, message = "No se encontraron usuarios en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public List<Estado> findAll(){
        return estadoService.findAll();
    }

    @ApiOperation(value = "Buscar un Estado por identificador",
            notes = "Se debe pasar el id del modelo Estado",
            response = Estado.class,
            responseContainer = "Estado")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/{id}")
    public Estado findById(@PathVariable("id") Integer id) throws Exception {
        return estadoService.findById(id);
    }

    @ApiOperation(value = "Ingresar un Estado",
            notes = "Se debe pasar el objeto del modelo Estado",
            response = Estado.class,
            responseContainer = "Estado")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Estado save(@RequestBody Estado estado){
        return estadoService.save(estado);
    }

    @ApiOperation(value = "Actualizar un Estado",
            notes = "Se debe pasar el objeto del modelo Estado a modificar",
            response = Estado.class,
            responseContainer = "Estado")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Estado update(@RequestBody Estado estado){
        return estadoService.update(estado);
    }

    @ApiOperation(value = "Eliminar un Estado",
            notes = "Se debe pasar el id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "Borrado OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        estadoService.deleteById(id);
        return "estado eliminado correctamente";
    }
}
