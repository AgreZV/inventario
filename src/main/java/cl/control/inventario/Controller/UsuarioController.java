package cl.control.inventario.Controller;

import cl.control.inventario.Model.Usuario;
import cl.control.inventario.Service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ApiOperation(value = "Obtener el listado de Usuarios",
            notes = "no requiere parametros de entrada",
            response = List.class,
            responseContainer = "ListUsuarios")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrados"),
            @ApiResponse(code = 405, message = "No se encontraron usuarios en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @ApiOperation(value = "Buscar un Usuario por identificador",
            notes = "Se debe pasar el id del modelo Usuario",
            response = Usuario.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Integer id) throws Exception {
        return usuarioService.findById(id);
    }

    @ApiOperation(value = "Ingresar un Usuario",
            notes = "Se debe pasar el objeto del modelo Usuario",
            response = Usuario.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @ApiOperation(value = "Actualizar un Usuario",
            notes = "Se debe pasar el objeto del modelo Usuario a modificar",
            response = Usuario.class,
            responseContainer = "Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Datos no enviados correctamente"),
            @ApiResponse(code = 200, message = "OK")})
    @PutMapping
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }

    @ApiOperation(value = "Eliminar un Usuario",
            notes = "Se debe pasar el id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No encontrado"),
            @ApiResponse(code = 200, message = "Borrado OK")})
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) throws Exception {
        usuarioService.deleteById(id);
        return "Usuario eliminado correctamente";
    }

/*    @GetMapping("/pageable")
    public ResponseEntity<Page<Usuario>> listarPageable(Pageable pageable) {
        Page<Usuario> usuarios = usuarioService.listarPageable(pageable);
        return new ResponseEntity<Page<Usuario>>(usuarios, HttpStatus.OK);
    }*/
}
