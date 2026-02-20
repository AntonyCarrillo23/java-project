package com.proyectos.api_gestion_proyectos.aplication.usecase.usuario;

import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class ListarUsuariosUseCase {
    private final UsuarioRepository usuarioRepository;

    public ListarUsuariosUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> ejecutar(){
        return usuarioRepository.findAll();
    }
}
