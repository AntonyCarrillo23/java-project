package com.proyectos.api_gestion_proyectos.presentation.rest.mapper;

import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearUsuarioRequest;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.UsuarioResponseDto;
import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioRestMapper {

    public static UsuarioResponseDto toResponse(Usuario usuario) {
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getApellidoUsuario(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getRol(),
                usuario.isActivo()
        );
    }

    public static List<UsuarioResponseDto> toResponseList(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioRestMapper::toResponse)
                .collect(Collectors.toList());
    }
    public static Usuario toDomain(CrearUsuarioRequest dto) {
        return new Usuario(
                null,
                dto.getNombreUsuario(),
                dto.getApellidoUsuario(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getRol(),
                true
        );
    }
}
