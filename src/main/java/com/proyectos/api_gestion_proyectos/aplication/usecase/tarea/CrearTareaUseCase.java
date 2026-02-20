package com.proyectos.api_gestion_proyectos.aplication.usecase.tarea;

import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;

public class CrearTareaUseCase {
    private final TareaRepository tareaRepository;

    public CrearTareaUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea crearTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }
}
