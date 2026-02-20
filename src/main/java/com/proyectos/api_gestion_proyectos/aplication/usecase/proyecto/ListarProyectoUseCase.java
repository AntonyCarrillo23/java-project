package com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto;

import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;

import java.util.List;

public class ListarProyectoUseCase {
    private final ProyectoRepository proyectoRepository;

    public ListarProyectoUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> listarProyecto(){
        return proyectoRepository.findAll();
    }
}
