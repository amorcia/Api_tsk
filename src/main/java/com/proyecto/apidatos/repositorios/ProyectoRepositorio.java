package com.proyecto.apidatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.apidatos.entidades.ProyectoEntidad;
import java.util.List;

@Repository
public interface ProyectoRepositorio extends JpaRepository<ProyectoEntidad, Integer> {
    List<ProyectoEntidad> findByCreadorNombre(String creador);
}
