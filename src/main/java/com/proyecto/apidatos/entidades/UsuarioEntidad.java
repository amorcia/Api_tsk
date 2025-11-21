package com.proyecto.apidatos.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad Usuario actualizada para incluir:
 *  - tokenSecret: guardado tal cual (lo crea/gestiona el backend)
 *  - codigoRecuperacion: código enviado por backend para recuperar contraseña
 *  - fechaExpiracionCodigo: fecha de expiración para ese código
 *
 * En la creación de usuario, la API hará hash de la contraseña inicial "tsk006".
 */
@Entity
@Table(name = "Usuarios")
public class UsuarioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // hash bcrypt

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private RolEntidad rol;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "token_secret", length = 1024)
    private String tokenSecret;

    @Column(name = "codigo_recuperacion", length = 128)
    private String codigoRecuperacion;

    @Column(name = "codigo_expiracion")
    private LocalDateTime fechaExpiracionCodigo;

    public UsuarioEntidad() {}

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public RolEntidad getRol() { return rol; }
    public void setRol(RolEntidad rol) { this.rol = rol; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getTokenSecret() { return tokenSecret; }
    public void setTokenSecret(String tokenSecret) { this.tokenSecret = tokenSecret; }

    public String getCodigoRecuperacion() { return codigoRecuperacion; }
    public void setCodigoRecuperacion(String codigoRecuperacion) { this.codigoRecuperacion = codigoRecuperacion; }

    public LocalDateTime getFechaExpiracionCodigo() { return fechaExpiracionCodigo; }
    public void setFechaExpiracionCodigo(LocalDateTime fechaExpiracionCodigo) { this.fechaExpiracionCodigo = fechaExpiracionCodigo; }
}
