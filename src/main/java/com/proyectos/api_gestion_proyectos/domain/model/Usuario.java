package com.proyectos.api_gestion_proyectos.domain.model;

public class Usuario {

    private Long id;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String email;
    private String password;
    private String rol;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String apellidoUsuario, String email, String password, String rol, boolean activo) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.email = email;
        this.password=password;
        this.rol=rol;
        this.activo = activo;
    }
    public void cambiarEstado(boolean activo) {
        this.activo = activo;
    }
    public void actualizarUsuario(String nombreUsuario, String apellidoUsuario, String email, String password){
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsuario=apellidoUsuario;
        this.email=email;
        this.password=password;
    }
    public void eliminarUsuario(){
        this.activo=false;
    }

    public Long getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
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

    public boolean isActivo() {
        return activo;
    }
}
