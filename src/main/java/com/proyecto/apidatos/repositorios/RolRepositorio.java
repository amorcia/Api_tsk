package com.proyecto.apidatos.repositorios;

import com.proyecto.apidatos.entidades.RolEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<RolEntidad, Integer> {
    RolEntidad findByNombre(String nombre);
}
