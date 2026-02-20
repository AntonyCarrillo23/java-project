package com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto;

import com.proyectos.api_gestion_proyectos.domain.exception.ProyectoNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.exception.UsuarioNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;

import java.util.Optional;

public class ListarProyectoByIdUseCase {
    private final ProyectoRepository proyectoRepository;

    public ListarProyectoByIdUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public Proyecto listarProyectoById(Long id){
        return proyectoRepository.findById(id)
                .orElseThrow(()->new ProyectoNoEncontradoException(id));
    }
}
