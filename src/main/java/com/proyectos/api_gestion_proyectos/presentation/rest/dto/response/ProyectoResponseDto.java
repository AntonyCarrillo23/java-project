package com.proyectos.api_gestion_proyectos.presentation.rest.dto.response;

import java.time.LocalDate;

public class ProyectoResponseDto {
    private Long idProyecto;
    private String nombreProyecto;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    public ProyectoResponseDto(Long idProyecto,String nombreProyecto, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.idProyecto=idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

   public Long getIdProyecto() {
        return idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public String getEstado() {
        return estado;
    }
}
