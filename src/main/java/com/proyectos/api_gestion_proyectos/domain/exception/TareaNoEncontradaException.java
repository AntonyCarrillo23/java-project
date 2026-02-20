package com.proyectos.api_gestion_proyectos.domain.exception;

public class TareaNoEncontradaException extends RuntimeException {
    public TareaNoEncontradaException(Long id) {

        super("Tarea con id " + id + " no encontrada");
    }
}
