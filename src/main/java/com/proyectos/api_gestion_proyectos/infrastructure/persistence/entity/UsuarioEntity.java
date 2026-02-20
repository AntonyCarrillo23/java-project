package com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios", schema = "gestion_proyectos")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombre;

    @Column (name = "apellido_usuario",nullable = false)
    private String apellido;

    @Column (name = "email",nullable = false)
    private String email;

    @Column (name = "password", nullable = false)
    private String password;

    @Column (name="rol", nullable = false)
    private String rol;

    @Column (name = "es_activo", nullable = false)
    private boolean activo;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nombre, String apellido, String email, String password, String rol, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password=password;
        this.rol=rol;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
