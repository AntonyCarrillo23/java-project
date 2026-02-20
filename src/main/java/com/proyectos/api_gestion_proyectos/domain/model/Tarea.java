package com.proyectos.api_gestion_proyectos.domain.model;

import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.ProyectoEntity;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.UsuarioEntity;

import java.time.LocalDate;

public class Tarea {
    private Long idTarea;
    private Long idProyecto;
    private Long idUsuario;
    private String titulo;
    private String descripcion;
    private EstadoTarea estado;
    private LocalDate fechaVencimiento;
    private LocalDate fechaModificacion;

    public Tarea(Long idTarea, Long idProyecto, Long idUsuario, String titulo, String descripcion, EstadoTarea estado, LocalDate fechaVencimiento) {
        this.idTarea = idTarea;
        this.idProyecto = idProyecto;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
    }
    public void asignarTareaUsuario(Long idUsuario){
        if ("FINALIZADA".equals(this.estado) ||
                "CANCELADA".equals(this.estado)) {

            throw new IllegalStateException(
                    "No se puede asignar usuario a una tarea cerrada"
            );
        }
        this.idUsuario=idUsuario;
        this.fechaModificacion=LocalDate.now();
    }
    public void cambiarEstado(EstadoTarea estado){
        this.estado=estado;
    }
    public void actualizarTarea(Long idProyecto,Long idUsuario, String titulo, String descripcion, EstadoTarea estado, LocalDate fechaVencimiento){
        this.idProyecto=idProyecto;
        this.idUsuario=idUsuario;
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.estado=estado;
        this.fechaVencimiento=fechaVencimiento;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
}
