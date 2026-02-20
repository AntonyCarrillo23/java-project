package com.proyectos.api_gestion_proyectos.presentation.rest.dto.response;

import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.ProyectoEntity;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.UsuarioEntity;

import java.time.LocalDate;

public class TareaResponseDto {
    private Long idTarea;
    private Long idProyecto;
    private Long idUsuario;
    private String titulo;
    private String descripcion;
    private EstadoTarea estado;
    private LocalDate fechaVencimiento;

    public TareaResponseDto() {
    }

    public TareaResponseDto(Long idTarea, Long idProyecto, Long idUsuario, String titulo, String descripcion, EstadoTarea estado, LocalDate fechaVencimiento) {
        this.idTarea = idTarea;
        this.idProyecto = idProyecto;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
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
