package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "\"TaskStatus\"")
public class EstadoTareaEntidad {

    @Id
    private Integer id;

    @Column(nullable=false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="proyecto_id")
    private ProyectoEntidad proyecto;

    private String color;

    private Integer orden;

    @Column(name="es_estado_final")
    private Boolean esEstadoFinal;

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

	public ProyectoEntidad getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoEntidad proyecto) {
		this.proyecto = proyecto;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Boolean getEsEstadoFinal() {
		return esEstadoFinal;
	}

	public void setEsEstadoFinal(Boolean esEstadoFinal) {
		this.esEstadoFinal = esEstadoFinal;
	}

    
}
