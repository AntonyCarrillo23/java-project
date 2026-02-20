package com.proyectos.api_gestion_proyectos.domain.model;

public enum EstadoTarea {
    FINALIZADA,
    EN_PROGRESO,
    PENDIENTE;
    public static boolean esValido(String nombre) {
        for (EstadoTarea estado : values()) {
            if (estado.name().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
