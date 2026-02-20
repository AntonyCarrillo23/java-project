package com.proyectos.api_gestion_proyectos.domain.model;

import java.time.LocalDate;

public class Proyecto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

   public Proyecto(Long id, String nombre, String descripcion, String estado, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado=estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public void cambiarEstado(String estado){
       this.estado=estado;
    }
    public void actualizarProyecto(String nombre, String descripcion, String estado, LocalDate fechaInicio, LocalDate fechaFin){
       this.nombre=nombre;
       this.descripcion=descripcion;
       this.estado=estado;
       this.fechaInicio=fechaInicio;
       this.fechaFin=fechaFin;
    }
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

}
