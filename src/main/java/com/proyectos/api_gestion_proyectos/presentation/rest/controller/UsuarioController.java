package com.proyectos.api_gestion_proyectos.presentation.rest.controller;

import com.proyectos.api_gestion_proyectos.aplication.usecase.usuario.*;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearUsuarioRequest;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.ApiResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.UsuarioResponseDto;
import com.proyectos.api_gestion_proyectos.presentation.rest.mapper.UsuarioRestMapper;
import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuarios", description = "Gestión de usuarios")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;
    private final CambiarEstadoUsuarioUseCase cambiarEstadoUsuarioUseCase;
    private final ListarUsuarioByIdUseCase listarUsuarioByIdUseCase;
    private final ActualizarUsuarioUseCase actualizarUsuarioUseCase;
    private final EliminarUsuarioUseCase eliminarUsuarioUseCase;

    public UsuarioController(CrearUsuarioUseCase crearUsuarioUseCase, ListarUsuariosUseCase listarUsuariosUseCase, CambiarEstadoUsuarioUseCase cambiarEstadoUsuarioUseCase, ListarUsuarioByIdUseCase listarUsuarioByIdUseCase, ActualizarUsuarioUseCase actualizarUsuarioUseCase, EliminarUsuarioUseCase eliminarUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
        this.listarUsuariosUseCase = listarUsuariosUseCase;
        this.cambiarEstadoUsuarioUseCase = cambiarEstadoUsuarioUseCase;
        this.listarUsuarioByIdUseCase = listarUsuarioByIdUseCase;
        this.actualizarUsuarioUseCase = actualizarUsuarioUseCase;
        this.eliminarUsuarioUseCase = eliminarUsuarioUseCase;
    }

    //Listar usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {
        return ResponseEntity.ok(
                listarUsuariosUseCase.ejecutar()
                        .stream()
                        .map(UsuarioRestMapper::toResponse)
                        .toList()
        );
    }

    //Obtener usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<UsuarioResponseDto>> listarById(@PathVariable Long id) {
        Usuario usuario = listarUsuarioByIdUseCase.ejecutar(id);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Usuario obtenido correctamente",
                        UsuarioRestMapper.toResponse(usuario)
                )
        );
    }

    //Crear usuario
    @PostMapping
    public ResponseEntity<ApiResponseDto<UsuarioResponseDto>> crear(@RequestBody CrearUsuarioRequest request) {
        Usuario usuario = crearUsuarioUseCase.ejecutar(
                UsuarioRestMapper.toDomain(request)
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ApiResponseDto<>(
                        true,
                        "Usuario creado correctamente",
                        UsuarioRestMapper.toResponse(usuario)
                ));
    }

    //Actualizar estado
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Usuario> cambiarEstado(
            @PathVariable Long id,
            @RequestParam boolean activo) {
        return ResponseEntity.ok(
                cambiarEstadoUsuarioUseCase.ejecutar(id, activo)
        );
    }

    //Actualizar usuario por id
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<UsuarioResponseDto>> actualizar(@PathVariable Long id,
    @RequestBody CrearUsuarioRequest request){
        Usuario usuarioUpdate=actualizarUsuarioUseCase.ejecutar(id,request);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        true,
                        "Usuario actualizado correctamente",
                        UsuarioRestMapper.toResponse(usuarioUpdate)
                )
        );
    }

    //Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        eliminarUsuarioUseCase.ejecutar(id);
        return ResponseEntity.noContent().build();
    }

}
