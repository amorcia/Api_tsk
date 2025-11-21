package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"Activity\"")
public class ActividadEntidad {

    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable=false)
    private UsuarioEntidad usuario;

    @Column(name="tipo_accion")
    private String tipoAccion;

    @Column(name="entidad_tipo")
    private String entidadTipo;

    @Column(name="entidad_id")
    private Integer entidadId;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(columnDefinition = "json")
    private String datosAnteriores;

    @Column(columnDefinition = "json")
    private String datosNuevos;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

    // getters y setters
}
