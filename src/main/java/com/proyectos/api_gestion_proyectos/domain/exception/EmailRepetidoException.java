package com.proyectos.api_gestion_proyectos.domain.exception;

public class EmailRepetidoException extends RuntimeException {
    public EmailRepetidoException() {
        super("El correo ya está registrado");
    }
}
