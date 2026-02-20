package com.proyectos.api_gestion_proyectos.domain.repository;

import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import java.util.List;
import java.util.Optional;

public interface TareaRepository {
    Tarea save(Tarea tarea);
    Optional<Tarea> findById(Long id);
    List<Tarea> findAll();
    long contarPorProyecto(Long idProyecto);
    long contarPorProyectoYEstado(Long idProyecto, EstadoTarea estado);
    List<Tarea> listarPorProyecto(Long idProyecto);

}
