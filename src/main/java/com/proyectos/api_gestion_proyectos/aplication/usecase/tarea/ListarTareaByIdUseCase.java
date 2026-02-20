package com.proyectos.api_gestion_proyectos.aplication.usecase.tarea;

import com.proyectos.api_gestion_proyectos.domain.exception.TareaNoEncontradaException;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;


public class ListarTareaByIdUseCase {
    private final TareaRepository tareaRepository;

    public ListarTareaByIdUseCase(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

   public Tarea buscarPorId(Long id){
        return tareaRepository.findById(id)
                .orElseThrow(()->new TareaNoEncontradaException(id));
    }
}
