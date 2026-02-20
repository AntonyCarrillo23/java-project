package com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto;

import com.proyectos.api_gestion_proyectos.domain.exception.EstadoInvalidoException;
import com.proyectos.api_gestion_proyectos.domain.exception.FechaFinException;
import com.proyectos.api_gestion_proyectos.domain.exception.ProyectoNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearProyectoRequest;

import java.util.List;

public class ActualizarProyectoUseCase {
    private final ProyectoRepository proyectoRepository;

    public ActualizarProyectoUseCase(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public Proyecto actualizarProyecto(Long idProyecto, CrearProyectoRequest request){
        Proyecto proyectoUpdate=proyectoRepository.findById(idProyecto)
                .orElseThrow(()->new ProyectoNoEncontradoException(idProyecto));
        List<String> estadosValidos = List.of("ACTIVO", "PENDIENTE", "FINALIZADO");
        if (!estadosValidos.contains(request.getEstado().toUpperCase())) {
            throw new EstadoInvalidoException(request.getEstado());
        }
        if(request.getFechaFin().isBefore(request.getFechaInicio())){
            throw new FechaFinException();
        }
        proyectoUpdate.actualizarProyecto(
                request.getNombreProyecto(),
                request.getDescripcion(),
                request.getEstado(),
                request.getFechaInicio(),
                request.getFechaFin());

        return proyectoRepository.save(proyectoUpdate);
    }
}
