package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"Team\"")
public class EquipoEntidad {

    @Id
    private Integer id;

    private String nombre;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(name="avatar_url")
    private String avatarUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lider_id", nullable=false)
    private UsuarioEntidad lider;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

    private Boolean activo;

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

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public UsuarioEntidad getLider() {
		return lider;
	}

	public void setLider(UsuarioEntidad lider) {
		this.lider = lider;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
    
}
