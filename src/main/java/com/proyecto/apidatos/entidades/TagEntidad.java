package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "\"Tag\"")
public class TagEntidad {

    @Id
    private Integer id;

    @Column(nullable=false)
    private String nombre;

    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="proyecto_id")
    private ProyectoEntidad proyecto;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ProyectoEntidad getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoEntidad proyecto) {
		this.proyecto = proyecto;
	}
    
}
