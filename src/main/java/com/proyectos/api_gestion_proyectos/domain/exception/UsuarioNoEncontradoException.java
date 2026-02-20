package com.proyectos.api_gestion_proyectos.domain.exception;

public class UsuarioNoEncontradoException extends  RuntimeException{
    public UsuarioNoEncontradoException(Long id) {
        super("Usuario con id " + id + " no encontrado");
    }
}
