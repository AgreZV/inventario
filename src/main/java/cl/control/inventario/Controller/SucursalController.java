package cl.control.inventario.Controller;

import cl.control.inventario.Model.Sucursal;
import cl.control.inventario.Service.SucursalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @ApiOperation(value = "Obtener el listado de Sucursales",
            notes = "no requiere parametros de entrada",
            response = List.class,
            responseContainer = "ListSucursales")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrados"),
            @ApiResponse(code = 405, message = "No se encontraron usuarios en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public List<Sucursal> findAll(){
        return sucursalService.findAll();
    }

    @ApiOperation(value = "Buscar una Sucursal por identificador",
            notes = "Se debe pasar el id del modelo Sucursal",
            response = Sucursal.class,
            responseContainer = "Sucursal")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/{id}")
    public Sucursal findById(@PathVariable("id") Integer id) throws Exception {
        return sucursalService.findById(id);
    }

    @ApiOperation(value = "Ingresar un Sucursal",
            notes = "Se debe pasar el objeto del modelo Sucursal",
            response = Sucursal.class,
            responseContainer = "Sucursal")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Sucursal save(@RequestBody Sucursal sucursal){
        return sucursalService.save(sucursal);
    }

    @ApiOperation(value = "Actualizar un Sucursal",
            notes = "Se debe pasar el objeto del modelo Sucursal a modificar",
            response = Sucursal.class,
            responseContainer = "Sucursal")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Sucursal update(@RequestBody Sucursal sucursal){
        return sucursalService.update(sucursal);
    }

    @ApiOperation(value = "Eliminar un Sucursal",
            notes = "Se debe pasar el id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "Borrado OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        sucursalService.deleteById(id);
        return "sucursal eliminado correctamente";
    }

}
