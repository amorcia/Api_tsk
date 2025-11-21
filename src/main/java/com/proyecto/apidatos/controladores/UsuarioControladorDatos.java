package com.proyecto.apidatos.controladores;

import com.proyecto.apidatos.dtos.UsuarioDTO;
import com.proyecto.apidatos.servicios.UsuarioServicioDatos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de la API de datos.
 * Rutas:
 *  GET  /api-datos/usuarios
 *  GET  /api-datos/usuarios/email?email=...
 *  POST /api-datos/usuarios
 *  PUT  /api-datos/usuarios/email?email=...
 *  DELETE /api-datos/usuarios/email?email=...
 *
 * Nota: la API no envía emails ni maneja tokens; solo persiste datos.
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControladorDatos {

    private final UsuarioServicioDatos servicio;

    public UsuarioControladorDatos(UsuarioServicioDatos servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @GetMapping("/email")
    public ResponseEntity<UsuarioDTO> obtenerPorEmail(@RequestParam String email) {
        UsuarioDTO dto = servicio.buscarPorEmail(email);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO creado = servicio.crearUsuario(usuario);
        return ResponseEntity.status(201).body(creado);
    }

    @PutMapping("/email")
    public ResponseEntity<UsuarioDTO> actualizarPorEmail(@RequestParam String email, @RequestBody UsuarioDTO usuario) {
        UsuarioDTO actualizado = servicio.actualizarUsuarioPorEmail(email, usuario);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/email")
    public ResponseEntity<Void> eliminarPorEmail(@RequestParam String email) {
        servicio.eliminarPorEmail(email);
        return ResponseEntity.noContent().build();
    }
}
