package com.proyectos.api_gestion_proyectos.presentation.rest.dto.request;

public class CrearUsuarioRequest {
    public String nombreUsuario;
    public String apellidoUsuario;
    public String email;
    public String password;
    public String rol;

    public CrearUsuarioRequest() {
    }

    public CrearUsuarioRequest(String nombreUsuario, String apellidoUsuario, String email, String password, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.email = email;
        this.password=password;
        this.rol=rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
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
}
