package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"Notification\"")
public class NotificacionEntidad {

    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable=false)
    private UsuarioEntidad usuario;

    private String tipo;
    private String titulo;

    @Column(columnDefinition = "text")
    private String mensaje;

    @Column(name="referencia_tipo")
    private String referenciaTipo;

    @Column(name="referencia_id")
    private Integer referenciaId;

    private Boolean leida;

    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name="fecha_lectura")
    private LocalDateTime fechaLectura;

    // getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioEntidad getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntidad usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getReferenciaTipo() {
		return referenciaTipo;
	}

	public void setReferenciaTipo(String referenciaTipo) {
		this.referenciaTipo = referenciaTipo;
	}

	public Integer getReferenciaId() {
		return referenciaId;
	}

	public void setReferenciaId(Integer referenciaId) {
		this.referenciaId = referenciaId;
	}

	public Boolean getLeida() {
		return leida;
	}

	public void setLeida(Boolean leida) {
		this.leida = leida;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaLectura() {
		return fechaLectura;
	}

	public void setFechaLectura(LocalDateTime fechaLectura) {
		this.fechaLectura = fechaLectura;
	}

    
}
