package com.proyectos.api_gestion_proyectos.aplication.usecase.tarea;

import com.proyectos.api_gestion_proyectos.domain.exception.TareaNoEncontradaException;
import com.proyectos.api_gestion_proyectos.domain.exception.UsuarioNoEncontradoException;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;

public class AsignarTareaUsuarioUseCase {
    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;

    public AsignarTareaUsuarioUseCase(TareaRepository tareaRepository, UsuarioRepository usuarioRepository) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void asignarTareaUsuario(Long idTarea, Long idUsuario){
        Tarea tareaUsuario=tareaRepository.findById(idTarea)
                .orElseThrow(()->new TareaNoEncontradaException(idTarea));

       if (!usuarioRepository.existsById(idUsuario)) {
            throw new UsuarioNoEncontradoException(idUsuario);
        }

        tareaUsuario.asignarTareaUsuario(idUsuario);
        tareaRepository.save(tareaUsuario);
    }
}
