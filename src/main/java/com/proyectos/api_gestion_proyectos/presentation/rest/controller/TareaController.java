package com.proyectos.api_gestion_proyectos.presentation.rest.controller;

import com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto.CambiarEstadoProyectoUseCase;
import com.proyectos.api_gestion_proyectos.aplication.usecase.tarea.*;
import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.AsignarUsuarioRequest;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearTareaRequest;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.ApiResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.ProyectoResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.TareaResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.mapper.ProyectoRestMapper;
import com.proyectos.api_gestion_proyectos.presentation.rest.mapper.TareaRestMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tareas", description = "Gestión de los tareas")
@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    private final CrearTareaUseCase crearTareaUseCase;
    private final ListarTareaUseCase listarTareaUseCase;
    private final ListarTareaByIdUseCase listarTareaByIdUseCase;
    private final ActualizarTareaUseCase actualizarTareaUseCase;
    private final CambiarEstadoTareaUseCase cambiarEstadoTareaUseCase;
    private final AsignarTareaUsuarioUseCase asignarTareaUsuarioUseCase;

    public TareaController(CrearTareaUseCase crearTareaUseCase, ListarTareaUseCase listarTareaUseCase, ListarTareaByIdUseCase listarTareaByIdUseCase, ActualizarTareaUseCase actualizarTareaUseCase, CambiarEstadoTareaUseCase cambiarEstadoTareaUseCase, AsignarTareaUsuarioUseCase asignarTareaUsuarioUseCase) {
        this.crearTareaUseCase = crearTareaUseCase;
        this.listarTareaUseCase = listarTareaUseCase;
        this.listarTareaByIdUseCase = listarTareaByIdUseCase;
        this.actualizarTareaUseCase = actualizarTareaUseCase;
        this.cambiarEstadoTareaUseCase = cambiarEstadoTareaUseCase;
        this.asignarTareaUsuarioUseCase = asignarTareaUsuarioUseCase;
    }
    //Crear
    @PostMapping
    public ResponseEntity<ApiResponseDto<TareaResponseDto>> crearTarea(@RequestBody CrearTareaRequest request){
        Tarea tarea=crearTareaUseCase.crearTarea(
                TareaRestMapper.toDomain(request)
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ApiResponseDto<>(
                                true,
                                "Tarea creada correctamente",
                                TareaRestMapper.toResponse(tarea)
                        ));
    }
    //Listar
    @GetMapping
    public ResponseEntity<List<TareaResponseDto>> listarTarea(){
        return ResponseEntity.ok(
                listarTareaUseCase.listarTareas()
                        .stream()
                        .map(TareaRestMapper::toResponse)
                        .toList()
        );
    }
    //Listar por id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<TareaResponseDto>> listarById(Long id){
        Tarea tarea=listarTareaByIdUseCase.buscarPorId(id);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Tarea obtenida correctamente",
                        TareaRestMapper.toResponse(tarea)
                )
        );
    }
    //Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<TareaResponseDto>> actualizar(
            @PathVariable Long id, @RequestBody CrearTareaRequest request
    ){
        Tarea tarea=actualizarTareaUseCase.actualizarTarea(id,request);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Tarea actualizada correctamente",
                        TareaRestMapper.toResponse(tarea)
                )
        );
    }
    //Actualizar estado
    @PatchMapping("/{id}/estado")
    public ResponseEntity<ApiResponseDto<TareaResponseDto>> cambiarEstado(
            @PathVariable Long id,
            @Parameter(schema = @Schema(allowableValues = {"FINALIZADA", "PENDIENTE", "EN_PROCESO"}))
            @RequestParam EstadoTarea estado
    ){
        Tarea tarea=cambiarEstadoTareaUseCase.cambiarEstado(id,estado);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Estado actualizado correctamente",
                        TareaRestMapper.toResponse(tarea)
                )
        );
    }

    @PatchMapping("/{id}/asignar")
    public ResponseEntity<ApiResponseDto<Void>> asignarUsuario(
            @PathVariable Long id,
            @RequestBody @Valid AsignarUsuarioRequest request
    ) {

        asignarTareaUsuarioUseCase.asignarTareaUsuario(id, request.getIdUsuario());

        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Usuario asignado correctamente",
                        null
                )
        );
    }

}
