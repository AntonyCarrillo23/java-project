package com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity;

import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tareas", schema = "gestion_proyectos")
public class TareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Long idTarea;

    // Aquí se crean las llaves foránea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto", nullable = false)
    private ProyectoEntity idProyecto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_asignado", nullable = false)
    private UsuarioEntity idUsuario;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoTarea estado;
    @Column(name = "due_date")
    private LocalDate fechaVencimiento;

    public TareaEntity() {
    }

    public TareaEntity(Long idTarea, ProyectoEntity idProyecto, UsuarioEntity idUsuario, String titulo, String descripcion, EstadoTarea estado, LocalDate fechaVencimiento) {
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

    public ProyectoEntity getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(ProyectoEntity idProyecto) {
        this.idProyecto = idProyecto;
    }

    public UsuarioEntity getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioEntity idUsuario) {
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
