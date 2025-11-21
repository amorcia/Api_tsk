package com.proyecto.apidatos.mapeadores;

import com.proyecto.apidatos.dtos.UsuarioDTO;
import com.proyecto.apidatos.entidades.UsuarioEntidad;

/**
 * Mapeos entre entidad y DTO, incluyendo los campos de recuperación.
 */
public class UsuarioMapeador {

    public static UsuarioDTO entidadADto(UsuarioEntidad entidad) {
        if (entidad == null) return null;
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setEmail(entidad.getEmail());
        dto.setPassword(entidad.getPassword());
        dto.setActivo(entidad.getActivo());
        dto.setTokenSecret(entidad.getTokenSecret());
        dto.setCodigoRecuperacion(entidad.getCodigoRecuperacion());
        dto.setFechaExpiracionCodigo(entidad.getFechaExpiracionCodigo());

        if (entidad.getRol() != null) {
            dto.setRolId(entidad.getRol().getId());
            dto.setRolNombre(entidad.getRol().getNombre());
        }
        return dto;
    }

    public static UsuarioEntidad dtoAEntidad(UsuarioDTO dto, com.proyecto.apidatos.entidades.RolEntidad rolEntidad) {
        if (dto == null) return null;
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setEmail(dto.getEmail());
        entidad.setPassword(dto.getPassword());
        entidad.setActivo(dto.getActivo() == null ? Boolean.TRUE : dto.getActivo());
        entidad.setTokenSecret(dto.getTokenSecret());
        entidad.setCodigoRecuperacion(dto.getCodigoRecuperacion());
        entidad.setFechaExpiracionCodigo(dto.getFechaExpiracionCodigo());
        entidad.setRol(rolEntidad);
        return entidad;
    }
}
