package com.proyectos.api_gestion_proyectos.aplication.usecase.usuario;

import com.proyectos.api_gestion_proyectos.domain.exception.EmailRepetidoException;
import com.proyectos.api_gestion_proyectos.domain.exception.UsuarioNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.request.CrearUsuarioRequest;

public class ActualizarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public ActualizarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario ejecutar(Long idUsuario, CrearUsuarioRequest request){
        Usuario usuarioUpdate = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNoEncontradoException(idUsuario));

        usuarioRepository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    if (!u.getId().equals(idUsuario)) {
                        throw new EmailRepetidoException();
                    }
                });

        usuarioUpdate.actualizarUsuario(
                    request.getNombreUsuario(),
                    request.getApellidoUsuario(),
                    request.getEmail(),
                    request.getPassword());

        return  usuarioRepository.save(usuarioUpdate);
    }
}
