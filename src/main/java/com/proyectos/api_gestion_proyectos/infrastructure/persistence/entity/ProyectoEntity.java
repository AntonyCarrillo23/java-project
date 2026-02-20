package com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "proyectos", schema = "gestion_proyectos")
public class ProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Long id;

    @Column(name = "nom_proyecto", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column (name = "fecha_inicio", nullable = false)
    private LocalDate  fechaInicio;

    @Column (name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "estado", nullable = false)
    private String estado;

    public ProyectoEntity() {
    }

    public ProyectoEntity(Long id, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
