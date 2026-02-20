package com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto;

import com.proyectos.api_gestion_proyectos.domain.exception.ProyectoNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;

public class CambiarEstadoProyectoUseCase {
    private final ProyectoRepository proyectoRepository;

    public CambiarEstadoProyectoUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }
    public Proyecto cambiarEstado(Long id, String estado){
        Proyecto proyecto=proyectoRepository.findById(id)
                .orElseThrow(()->new ProyectoNoEncontradoException(id));

        proyecto.cambiarEstado(estado);
        return proyectoRepository.save(proyecto);
    }
}
