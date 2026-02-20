package com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto;

import com.proyectos.api_gestion_proyectos.domain.exception.ProyectoNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;

public class ObtenerAvanceProyectoUseCase {
    private final ProyectoRepository proyectoRepository;
    private final TareaRepository tareaRepository;

    public ObtenerAvanceProyectoUseCase(
            ProyectoRepository proyectoRepository,
            TareaRepository tareaRepository
    ) {
        this.proyectoRepository = proyectoRepository;
        this.tareaRepository = tareaRepository;
    }

    public int ejecutar(Long idProyecto) {

        proyectoRepository.findById(idProyecto)
                .orElseThrow(() -> new ProyectoNoEncontradoException(idProyecto));

        long totalTareas = tareaRepository.contarPorProyecto(idProyecto);

        if (totalTareas == 0) {
            return 0;
        }

        long tareasFinalizadas =
                tareaRepository.contarPorProyectoYEstado(
                        idProyecto,
                        EstadoTarea.FINALIZADA
                );
        return (int) Math.round(
                (tareasFinalizadas * 100.0) / totalTareas
        );
    }
}
