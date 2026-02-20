package com.proyectos.api_gestion_proyectos.aplication.usecase.usuario;

import com.proyectos.api_gestion_proyectos.domain.exception.UsuarioNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

public class CambiarEstadoUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public CambiarEstadoUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario ejecutar(Long idUsuario, boolean activo) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNoEncontradoException(idUsuario));

        usuario.cambiarEstado(activo);
        return usuarioRepository.save(usuario);
    }

}
