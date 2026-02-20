package com.proyectos.api_gestion_proyectos.domain.exception;

public class ProyectoNoEncontradoException extends RuntimeException {
    public ProyectoNoEncontradoException( Long id) {

        super("Proyecto con id " + id + " no encontrado");
    }
}
