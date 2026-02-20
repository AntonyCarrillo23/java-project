package com.proyectos.api_gestion_proyectos.aplication.usecase.tarea;

import com.proyectos.api_gestion_proyectos.domain.exception.ProyectoNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.exception.TareaNoEncontradaException;
import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;

public class CambiarEstadoTareaUseCase {
    private final TareaRepository tareaRepository;

    public CambiarEstadoTareaUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
    public Tarea cambiarEstado(Long id, EstadoTarea estado){
        Tarea tarea=tareaRepository.findById(id)
                .orElseThrow(()->new TareaNoEncontradaException(id));

        tarea.cambiarEstado(estado);
        return tareaRepository.save(tarea);
    }
}
