package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "\"Comment\"")
public class ComentarioEntidad {

    @Id
    private Integer id;

    @Column(columnDefinition = "text", nullable=false)
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tarea_id", nullable=false)
    private TareaEntidad tarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="autor_id", nullable=false)
    private UsuarioEntidad autor;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name="fecha_edicion")
    private LocalDateTime fechaEdicion;

    private Boolean editado;

    // getters y setters
}
