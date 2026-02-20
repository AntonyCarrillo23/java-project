package com.proyectos.api_gestion_proyectos.infrastructure.config;

import com.proyectos.api_gestion_proyectos.aplication.usecase.tarea.*;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TareaUseCaseConfig {
    @Bean
    public CrearTareaUseCase crearTareaUseCase(TareaRepository tareaRepository){
        return new CrearTareaUseCase(tareaRepository);
    }
    @Bean
    public ListarTareaUseCase listarTareaUseCase(TareaRepository tareaRepository){
        return new ListarTareaUseCase(tareaRepository);
    }
    @Bean
    public ListarTareaByIdUseCase listarTareaByIdUseCase(TareaRepository tareaRepository){
        return new ListarTareaByIdUseCase(tareaRepository);
    }
    @Bean
    public ActualizarTareaUseCase actualizarTareaUseCase(TareaRepository tareaRepository){
        return new ActualizarTareaUseCase(tareaRepository);
    }
    @Bean
    public CambiarEstadoTareaUseCase cambiarEstadoTareaUseCase(TareaRepository tareaRepository){
        return new CambiarEstadoTareaUseCase(tareaRepository);
    }
    @Bean
    public AsignarTareaUsuarioUseCase asignarTareaUsuarioUseCase(TareaRepository tareaRepository, UsuarioRepository usuarioRepository){
        return new AsignarTareaUsuarioUseCase(tareaRepository,usuarioRepository);
    }
}
