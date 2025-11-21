package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"Attachment\"")
public class AdjuntoEntidad {

    @Id
    private Integer id;

    private String nombre;
    private String url;
    private String tipo;
    private Integer tamaño;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tarea_id")
    private TareaEntidad tarea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="comentario_id")
    private ComentarioEntidad comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subido_por_id", nullable=false)
    private UsuarioEntidad subidoPor;

    @Column(name="fecha_subida")
    private LocalDateTime fechaSubida;

    // getters y setters
}
