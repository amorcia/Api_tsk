package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "\"Task\"")
public class TareaEntidad {

    @Id
    private Integer id;

    @Column(nullable=false)
    private String titulo;

    @Column(columnDefinition = "text")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="proyecto_id", nullable=false)
    private ProyectoEntidad proyecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="estado_id", nullable=false)
    private EstadoTareaEntidad estado;

    private String prioridad;

    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creador_id", nullable=false)
    private UsuarioEntidad creador;

    @Column(name="fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name="fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name="estimacion_horas")
    private Float estimacionHoras;

    @Column(name="horas_trabajadas")
    private Float horasTrabajadas;

    private Integer orden;

    @Column(columnDefinition = "json")
    private String etiquetas;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name="fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @ManyToMany
    @JoinTable(
        name="\"Task_Tag\"",
        joinColumns = @JoinColumn(name="Task_id"),
        inverseJoinColumns = @JoinColumn(name="Tag_id")
    )
    private Set<TagEntidad> etiquetasSet;

    // getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ProyectoEntidad getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoEntidad proyecto) {
		this.proyecto = proyecto;
	}

	public EstadoTareaEntidad getEstado() {
		return estado;
	}

	public void setEstado(EstadoTareaEntidad estado) {
		this.estado = estado;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public UsuarioEntidad getCreador() {
		return creador;
	}

	public void setCreador(UsuarioEntidad creador) {
		this.creador = creador;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Float getEstimacionHoras() {
		return estimacionHoras;
	}

	public void setEstimacionHoras(Float estimacionHoras) {
		this.estimacionHoras = estimacionHoras;
	}

	public Float getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(Float horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Set<TagEntidad> getEtiquetasSet() {
		return etiquetasSet;
	}

	public void setEtiquetasSet(Set<TagEntidad> etiquetasSet) {
		this.etiquetasSet = etiquetasSet;
	}
  
}
