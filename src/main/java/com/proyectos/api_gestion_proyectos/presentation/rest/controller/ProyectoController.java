package com.proyectos.api_gestion_proyectos.presentation.rest.controller;

import com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto.*;
import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearProyectoRequest;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.ApiResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.AvanceProyectoResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.ProyectoResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.TareaResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.mapper.ProyectoRestMapper;;
import com.proyectos.api_gestion_proyectos.presentation.rest.mapper.TareaRestMapper;
import com.proyectos.api_gestion_proyectos.presentation.rest.mapper.UsuarioRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Proyectos", description = "Gestión de los proyectos")
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    private final CrearProyectoUseCase crearProyectoUseCase;
    private final ListarProyectoUseCase listarProyectoUseCase;
    private final ListarProyectoByIdUseCase listarProyectoByIdUseCase;
    private final ActualizarProyectoUseCase actualizarProyectoUseCase;
    private final CambiarEstadoProyectoUseCase cambiarEstadoProyectoUseCase;
    private final ObtenerAvanceProyectoUseCase obtenerAvanceProyectoUseCase;
    private final ListarTareasProyectoUseCase listarTareasProyectoUseCase;

    public ProyectoController(CrearProyectoUseCase crearProyectoUseCase, ListarProyectoUseCase listarProyectoUseCase, ListarProyectoByIdUseCase listarProyectoByIdUseCase, ActualizarProyectoUseCase actualizarProyectoUseCase, CambiarEstadoProyectoUseCase cambiarEstadoProyectoUseCase, ObtenerAvanceProyectoUseCase obtenerAvanceProyectoUseCase, ListarTareasProyectoUseCase listarTareasProyectoUseCase) {
        this.crearProyectoUseCase = crearProyectoUseCase;
        this.listarProyectoUseCase = listarProyectoUseCase;
        this.listarProyectoByIdUseCase = listarProyectoByIdUseCase;
        this.actualizarProyectoUseCase = actualizarProyectoUseCase;
        this.cambiarEstadoProyectoUseCase = cambiarEstadoProyectoUseCase;
        this.obtenerAvanceProyectoUseCase = obtenerAvanceProyectoUseCase;
        this.listarTareasProyectoUseCase = listarTareasProyectoUseCase;
    }


    //Crear proyectos
    @Operation(summary = "Crear un nuevo proyecto", description = "Permite registrar un proyecto. El estado por defecto es ACTIVO.")
    @PostMapping
    public ResponseEntity<ApiResponseDto<ProyectoResponseDto>> crearProyecto(@RequestBody CrearProyectoRequest request){
        Proyecto proyecto=crearProyectoUseCase.crearProyecto(
                ProyectoRestMapper.toDomain(request)
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ApiResponseDto<>(
                                true,
                                "Proyecto creado correctamente",
                                ProyectoRestMapper.toResponse(proyecto)
                        ));
    }
    //Listar Proyectos
    @GetMapping
    public ResponseEntity<List<ProyectoResponseDto>> listarProyecto(){
        return ResponseEntity.ok(
                listarProyectoUseCase.listarProyecto()
                        .stream()
                        .map(ProyectoRestMapper::toResponse)
                        .toList()
        );
    }

    //Listar proyectos por id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<ProyectoResponseDto>> listarById(@PathVariable Long id){
        Proyecto proyecto=listarProyectoByIdUseCase.listarProyectoById(id);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Proyecto obtenido correctamente",
                        ProyectoRestMapper.toResponse(proyecto)
                )
        );
    }
    //Actualizar proyectos
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<ProyectoResponseDto>> actualizar(
            @PathVariable Long id, @RequestBody CrearProyectoRequest request
    ){
        Proyecto proyecto= actualizarProyectoUseCase.actualizarProyecto(id,request);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Proyecto actualizado correctamente",
                        ProyectoRestMapper.toResponse(proyecto)
                )
        );
    }

    //Actualizar estado
    @PatchMapping("/{id}/estado")
    public ResponseEntity<ApiResponseDto<ProyectoResponseDto>> cambiarEstado(
            @PathVariable Long id,
            @Parameter(schema = @Schema(allowableValues = {"FINALIZADA", "CANCELADA", "EN_PROCESO"}))
            @RequestParam String estado
    ){
        Proyecto proyecto= cambiarEstadoProyectoUseCase.cambiarEstado(id,estado);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Estado actualizado correctamente",
                        ProyectoRestMapper.toResponse(proyecto)
                )
        );
    }

    //Avance de proyecto
    @GetMapping("/{id}/avance")
    public ResponseEntity<ApiResponseDto<AvanceProyectoResponseDto>> obtenerAvance(
            @PathVariable Long id
    ) {

        int porcentaje =
                obtenerAvanceProyectoUseCase.ejecutar(id);

        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Avance del proyecto calculado correctamente",
                        new AvanceProyectoResponseDto(id, porcentaje)
                )
        );
    }

    @GetMapping("/{id}/tareas")
    public ResponseEntity<ApiResponseDto<List<TareaResponseDto>>> listarTareasProyecto(
            @PathVariable Long id
    ) {

        List<Tarea> tareas = listarTareasProyectoUseCase.ejecutar(id);

        List<TareaResponseDto> response = tareas.stream()
                .map(TareaRestMapper::toResponse)
                .toList();

        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Tareas del proyecto obtenidas correctamente",
                        response
                )
        );
    }

}
