package com.proyectos.api_gestion_proyectos.aplication.usecase.usuario;

import com.proyectos.api_gestion_proyectos.domain.exception.EmailRepetidoException;
import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;


public class CrearUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario ejecutar(Usuario usuario) {
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new EmailRepetidoException();
        }
        return usuarioRepository.save(usuario);
    }
}
