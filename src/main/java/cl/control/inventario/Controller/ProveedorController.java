package cl.control.inventario.Controller;

import cl.control.inventario.Model.Producto;
import cl.control.inventario.Model.Proveedor;
import cl.control.inventario.Service.ProductoService;
import cl.control.inventario.Service.ProveedorService;
import cl.control.inventario.dto.ConsultaDTO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ProductoService productoService;

    @ApiOperation(value = "Obtener el listado de Proveedores",
            notes = "no requiere parametros de entrada",
            response = List.class,
            responseContainer = "ListProveedores")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrados"),
            @ApiResponse(code = 405, message = "No se encontraron usuarios en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public List<Proveedor> findAll(){
        return proveedorService.findAll();
    }

    @ApiOperation(value = "Buscar un Proveedor por identificador",
            notes = "Se debe pasar el id del modelo Proveedor",
            response = Proveedor.class,
            responseContainer = "Proveedor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/{id}")
    public Proveedor findById(@PathVariable("id") Integer id) throws Exception {
        return proveedorService.findById(id);
    }

    @ApiOperation(value = "Ingresar un Proveedor",
            notes = "Se debe pasar el objeto del modelo Proveedor",
            response = Proveedor.class,
            responseContainer = "Proveedor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Proveedor save(@RequestBody Proveedor proveedor){
        return proveedorService.save(proveedor);
    }

    @ApiOperation(value = "Actualizar un Proveedor",
            notes = "Se debe pasar el objeto del modelo Proveedor a modificar",
            response = Proveedor.class,
            responseContainer = "Proveedor")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Proveedor update(@RequestBody Proveedor proveedor){
        return proveedorService.update(proveedor);
    }


    @ApiOperation(value = "Eliminar un Proveedor",
            notes = "Se debe pasar el id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "Borrado OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        proveedorService.deleteById(id);
        return "proveedor eliminado correctamente";
    }

    @ApiOperation(value = "Obtener el proveedor junto con sus productos en stock (DTO)",
            notes = "Se debe pasar el id del proveedor",
            response = ConsultaDTO.class,
            responseContainer = "ConsultaDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "OK")})
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "Id del proveedor", dataType = "Integer")})
    @GetMapping("/stockProductos/{id}")
    public ConsultaDTO findByIdConItems(@PathVariable("id") Integer id) throws Exception {
        Proveedor proveedor = proveedorService.findById(id);
        List<Producto> productos = productoService.findAllByProveedor(proveedor.getIdProveedor());
        return new ConsultaDTO(proveedor, productos);
    }

}
