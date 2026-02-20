package com.proyectos.api_gestion_proyectos.presentation.rest.dto.response;

public class UsuarioResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String rol;
    private boolean activo;

    public UsuarioResponseDto() {
    }

    public UsuarioResponseDto(Long id,String nombre, String apellido, String email, String password, String rol, boolean activo) {
        this.id=id;
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

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public String getApellido() {
        return apellido;
    }

}
