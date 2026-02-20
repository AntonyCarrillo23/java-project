package com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto;

import com.proyectos.api_gestion_proyectos.domain.exception.ProyectoNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;

import java.util.List;

public class ListarTareasProyectoUseCase {
    private final ProyectoRepository proyectoRepository;
    private final TareaRepository tareaRepository;

    public ListarTareasProyectoUseCase(ProyectoRepository proyectoRepository, TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.tareaRepository = tareaRepository;
    }
    public List<Tarea> ejecutar(Long idProyecto) {

        proyectoRepository.findById(idProyecto)
                .orElseThrow(() -> new ProyectoNoEncontradoException(idProyecto));

        return tareaRepository.listarPorProyecto(idProyecto);
    }
}
