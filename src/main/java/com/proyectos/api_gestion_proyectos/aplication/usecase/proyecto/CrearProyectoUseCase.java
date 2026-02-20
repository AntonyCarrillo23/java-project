package com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto;

import com.proyectos.api_gestion_proyectos.domain.exception.FechaFinException;
import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;

public class CrearProyectoUseCase {
    private final ProyectoRepository proyectoRepository;

    public CrearProyectoUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public Proyecto crearProyecto(Proyecto proyecto){
        if (proyecto.getFechaFin().isBefore(proyecto.getFechaInicio())){
            throw new FechaFinException();
        } else{
            return proyectoRepository.save(proyecto);
        }
    }
}
