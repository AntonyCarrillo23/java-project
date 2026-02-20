package com.proyectos.api_gestion_proyectos.presentation.rest.mapper;

import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearProyectoRequest;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.ProyectoResponseDto;

public class ProyectoRestMapper {
    public static ProyectoResponseDto toResponse(Proyecto proyecto){
        return new ProyectoResponseDto(
                proyecto.getId(),
                proyecto.getNombre(),
                proyecto.getDescripcion(),
                proyecto.getFechaInicio(),
                proyecto.getFechaFin(),
                proyecto.getEstado()
                );
    }

    public static Proyecto toDomain(CrearProyectoRequest request){
        return new Proyecto(
                null,
                request.getNombreProyecto(),
                request.getDescripcion(),
                "ACTIVO",
                request.getFechaInicio(),
                request.getFechaFin()
        );
    }
}
