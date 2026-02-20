package com.proyectos.api_gestion_proyectos.presentation.rest.dto.request;

import java.time.LocalDate;

public class CrearProyectoRequest {
    public String nombreProyecto;
    public String descripcion;
    public String estado;
    public LocalDate fechaInicio;
    public LocalDate fechaFin;

    public CrearProyectoRequest() {
    }

    public CrearProyectoRequest(String nombreProyecto, String descripcion, String estado, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombreProyecto = nombreProyecto;
        this.descripcion = descripcion;
        this.estado=estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

}
