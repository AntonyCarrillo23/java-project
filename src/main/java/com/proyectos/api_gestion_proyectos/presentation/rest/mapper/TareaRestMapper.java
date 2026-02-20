package com.proyectos.api_gestion_proyectos.presentation.rest.mapper;

import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearTareaRequest;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.TareaResponseDto;

public class TareaRestMapper {
    public static TareaResponseDto toResponse(Tarea tarea){
        return new TareaResponseDto(
                tarea.getIdTarea(),
                tarea.getIdProyecto(),
                tarea.getIdUsuario(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getEstado(),
                tarea.getFechaVencimiento()
        );
    }

    public static Tarea toDomain(CrearTareaRequest request){
        return new Tarea(
                null,
                request.getIdProyecto(),
                request.getIdUsuario(),
                request.getTitulo(),
                request.getDescripcion(),
                request.getEstado(),
                request.getFechaVencimiento()
                );
    }
}
