package com.proyectos.api_gestion_proyectos.domain.exception;

public class FechaFinException extends RuntimeException {
    public FechaFinException() {

        super("La fecha de fin debe ser mayor que la fecha de inicio");
    }
}
