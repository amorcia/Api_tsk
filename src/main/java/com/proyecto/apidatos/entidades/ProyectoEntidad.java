package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "\"Project\"")
public class ProyectoEntidad {

    @Id
    private Integer id;

    @Column(nullable=false)
    private String nombre;

    @Column(columnDefinition = "text")
    private String descripcion;

    private String tipo;

    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creador_id", nullable=false)
    private UsuarioEntidad creador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="equipo_id")
    private EquipoEntidad equipo;

    @Column(name="fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name="fecha_fin")
    private LocalDate fechaFin;

    private String estado;

    private Float progreso;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

    // getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public UsuarioEntidad getCreador() {
		return creador;
	}

	public void setCreador(UsuarioEntidad creador) {
		this.creador = creador;
	}

	public EquipoEntidad getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoEntidad equipo) {
		this.equipo = equipo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getProgreso() {
		return progreso;
	}

	public void setProgreso(Float progreso) {
		this.progreso = progreso;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
 
}
