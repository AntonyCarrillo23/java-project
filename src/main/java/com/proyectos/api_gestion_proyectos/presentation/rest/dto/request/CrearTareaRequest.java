package com.proyectos.api_gestion_proyectos.presentation.rest.dto.request;

import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import java.time.LocalDate;

public class CrearTareaRequest {
    private Long idProyecto;
    private Long idUsuario;
    private String titulo;
    private String descripcion;
    private EstadoTarea estado;
    private LocalDate fechaVencimiento;

    public CrearTareaRequest() {
    }

    public CrearTareaRequest(Long idProyecto, Long idUsuario, String titulo, String descripcion, EstadoTarea estado, LocalDate fechaVencimiento) {
        this.idProyecto = idProyecto;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
