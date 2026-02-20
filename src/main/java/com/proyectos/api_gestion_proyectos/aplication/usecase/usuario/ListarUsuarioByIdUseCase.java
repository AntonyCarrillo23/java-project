package com.proyectos.api_gestion_proyectos.aplication.usecase.usuario;

import com.proyectos.api_gestion_proyectos.domain.exception.ProyectoNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.exception.UsuarioNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;


public class ListarUsuarioByIdUseCase {
    private final UsuarioRepository usuarioRepository;

    public ListarUsuarioByIdUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario ejecutar(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(()->new UsuarioNoEncontradoException(id));
    }
}
