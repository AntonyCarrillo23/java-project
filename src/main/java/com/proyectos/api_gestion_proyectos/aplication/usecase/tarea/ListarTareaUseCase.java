package com.proyectos.api_gestion_proyectos.aplication.usecase.tarea;

import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;

import java.util.List;

public class ListarTareaUseCase {
    private final TareaRepository tareaRepository;

    public ListarTareaUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
    public List<Tarea> listarTareas(){
        return tareaRepository.findAll();
    }
}
