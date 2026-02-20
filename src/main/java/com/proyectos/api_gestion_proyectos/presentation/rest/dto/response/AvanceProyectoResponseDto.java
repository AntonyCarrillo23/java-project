package com.proyectos.api_gestion_proyectos.presentation.rest.dto.response;

public class AvanceProyectoResponseDto {
    private Long idProyecto;
    private int porcentaje;

    public AvanceProyectoResponseDto(Long idProyecto, int porcentaje) {
        this.idProyecto = idProyecto;
        this.porcentaje = porcentaje;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
}
