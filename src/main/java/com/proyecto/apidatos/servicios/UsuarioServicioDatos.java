package com.proyecto.apidatos.servicios;

import com.proyecto.apidatos.dtos.UsuarioDTO;
import com.proyecto.apidatos.entidades.RolEntidad;
import com.proyecto.apidatos.entidades.UsuarioEntidad;
import com.proyecto.apidatos.mapeadores.UsuarioMapeador;
import com.proyecto.apidatos.repositorios.RolRepositorio;
import com.proyecto.apidatos.repositorios.UsuarioRepositorio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de persistencia. TODO: No contiene lógica de seguridad adicional.
 * - Al crear usuario: aplica hash automáticamente de la contraseña inicial "tsk006"
 * - Actualiza/borra por email (no por id)
 */
@Service
public class UsuarioServicioDatos {

    private final UsuarioRepositorio usuarioRepositorio;
    private final RolRepositorio rolRepositorio;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioServicioDatos(UsuarioRepositorio usuarioRepositorio, RolRepositorio rolRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.rolRepositorio = rolRepositorio;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepositorio.findAll().stream().map(UsuarioMapeador::entidadADto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO buscarPorEmail(String email) {
        UsuarioEntidad e = usuarioRepositorio.findByEmail(email);
        return UsuarioMapeador.entidadADto(e);
    }

    @Transactional
    public UsuarioDTO crearUsuario(UsuarioDTO dto) {
        // El backend NO envía password; la API genera el password inicial "tsk006" y lo hashea
        String passwordInicial = "tsk006";
        String hashed = passwordEncoder.encode(passwordInicial);

        RolEntidad rol = null;
        if (dto.getRolId() != null) {
            rol = rolRepositorio.findById(dto.getRolId()).orElse(null);
        }

        UsuarioEntidad entidad = UsuarioMapeador.dtoAEntidad(dto, rol);
        entidad.setPassword(hashed);
        entidad.setFechaCreacion(LocalDateTime.now());

        UsuarioEntidad guardada = usuarioRepositorio.save(entidad);
        return UsuarioMapeador.entidadADto(guardada);
    }

    @Transactional
    public UsuarioDTO actualizarUsuarioPorEmail(String email, UsuarioDTO dto) {
        UsuarioEntidad existente = usuarioRepositorio.findByEmail(email);
        if (existente == null) return null;

        if (dto.getNombre() != null) existente.setNombre(dto.getNombre());
        if (dto.getEmail() != null) existente.setEmail(dto.getEmail());

        // Si el backend envía password, asumimos que viene hasheada y la guardamos tal cual
        if (dto.getPassword() != null) existente.setPassword(dto.getPassword());

        if (dto.getActivo() != null) existente.setActivo(dto.getActivo());
        if (dto.getTokenSecret() != null) existente.setTokenSecret(dto.getTokenSecret());

        if (dto.getCodigoRecuperacion() != null) existente.setCodigoRecuperacion(dto.getCodigoRecuperacion());
        if (dto.getFechaExpiracionCodigo() != null) existente.setFechaExpiracionCodigo(dto.getFechaExpiracionCodigo());

        if (dto.getRolId() != null) {
            RolEntidad rol = rolRepositorio.findById(dto.getRolId()).orElse(null);
            existente.setRol(rol);
        }

        UsuarioEntidad actualizado = usuarioRepositorio.save(existente);
        return UsuarioMapeador.entidadADto(actualizado);
    }

    @Transactional
    public void eliminarPorEmail(String email) {
        usuarioRepositorio.deleteByEmail(email);
    }
}
