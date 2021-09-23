package cl.control.inventario.Controller;

import cl.control.inventario.Model.Producto;
import cl.control.inventario.Model.Sucursal;
import cl.control.inventario.Service.ProductoService;
import cl.control.inventario.Service.SucursalService;
import cl.control.inventario.dto.ConsultaDTO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private SucursalService sucursalService;

    @ApiOperation(value = "Obtener el listado de Productos",
            notes = "no requiere parametros de entrada",
            response = List.class,
            responseContainer = "ListProductos")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrados"),
            @ApiResponse(code = 405, message = "No se encontraron usuarios en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public List<Producto> findAll(){
        return productoService.findAll();
    }

    @ApiOperation(value = "Buscar un Producto por identificador",
            notes = "Se debe pasar el id del modelo Producto",
            response = Producto.class,
            responseContainer = "Producto")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/{id}")
    public Producto findById(@PathVariable("id") Integer id) throws Exception {
        return productoService.findById(id);
    }

    @ApiOperation(value = "Ingresar un Producto",
            notes = "Se debe pasar el objeto del modelo Producto",
            response = Producto.class,
            responseContainer = "Producto")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Producto save(@RequestBody Producto producto){
        return productoService.save(producto);
    }

    @ApiOperation(value = "Actualizar un Producto",
            notes = "Se debe pasar el objeto del modelo Producto a modificar",
            response = Producto.class,
            responseContainer = "Producto")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Producto update(@RequestBody Producto producto){
        return productoService.update(producto);
    }

    @ApiOperation(value = "Eliminar un Producto",
            notes = "Se debe pasar el id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "Borrado OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        productoService.deleteById(id);
        return "producto eliminado correctamente";
    }

}
