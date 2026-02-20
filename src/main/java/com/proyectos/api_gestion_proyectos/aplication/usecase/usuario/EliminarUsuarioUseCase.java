package com.proyectos.api_gestion_proyectos.aplication.usecase.usuario;

import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;

public class EliminarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public EliminarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario ejecutar(Long idUsuario){
        Usuario usuarioDelelete=usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioDelelete.eliminarUsuario();
        return usuarioRepository.save(usuarioDelelete);
    }
}
