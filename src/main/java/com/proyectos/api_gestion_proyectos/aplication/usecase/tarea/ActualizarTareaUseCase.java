package com.proyectos.api_gestion_proyectos.aplication.usecase.tarea;

import com.proyectos.api_gestion_proyectos.domain.exception.EstadoInvalidoException;
import com.proyectos.api_gestion_proyectos.domain.exception.TareaNoEncontradaException;
import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearTareaRequest;

import java.util.List;


public class ActualizarTareaUseCase {
    private final TareaRepository tareaRepository;

    public ActualizarTareaUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea actualizarTarea(Long id, CrearTareaRequest request){
        Tarea tarea=tareaRepository.findById(id)
                .orElseThrow(()->new TareaNoEncontradaException(id));
        tarea.actualizarTarea(
                request.getIdProyecto(),
                request.getIdUsuario(),
                request.getTitulo(),
                request.getDescripcion(),
                request.getEstado(),
                request.getFechaVencimiento()
        );
        return tareaRepository.save(tarea);
    }
}
