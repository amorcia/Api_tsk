package com.proyecto.apidatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.apidatos.entidades.TareaEntidad;
import java.util.List;

@Repository
public interface TareaRepositorio extends JpaRepository<TareaEntidad, Integer> {
    List<TareaEntidad> findByTitulo(String proyecto);
}
