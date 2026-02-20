package com.proyectos.api_gestion_proyectos.domain.exception;

public class EstadoInvalidoException extends RuntimeException {
    public EstadoInvalidoException(String estado) {
        super("Estado no permitido: " + estado);
    }
}
