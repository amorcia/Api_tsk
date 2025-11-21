package com.proyecto.apidatos.repositorios;

import com.proyecto.apidatos.entidades.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio: buscar por email y eliminar por email.
 * deleteByEmail declarado como void (JPA eliminará las filas correspondientes).
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, Integer> {
    UsuarioEntidad findByEmail(String email);
    void deleteByEmail(String email);
}
