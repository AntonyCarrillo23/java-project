package com.proyectos.api_gestion_proyectos.infrastructure.config;

import com.proyectos.api_gestion_proyectos.aplication.usecase.proyecto.*;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProyectoUseCaseConfig {
    //Proyectos
    @Bean
    public CrearProyectoUseCase crearProyectoUseCase(ProyectoRepository proyectoRepository){
        return new CrearProyectoUseCase(proyectoRepository);
    }

    @Bean
    public ListarProyectoUseCase listarProyectoUseCase(ProyectoRepository proyectoRepository){
        return new ListarProyectoUseCase(proyectoRepository);
    }
    @Bean
    public ListarProyectoByIdUseCase listarProyectoByIdUseCase(ProyectoRepository proyectoRepository){
        return new ListarProyectoByIdUseCase(proyectoRepository);
    }
    @Bean
    public ActualizarProyectoUseCase actualizarProyectoUseCase(ProyectoRepository proyectoRepository){
        return new ActualizarProyectoUseCase(proyectoRepository);
    }
    @Bean
    public CambiarEstadoProyectoUseCase cambiarEstadoProyectoUseCase(ProyectoRepository proyectoRepository){
        return new CambiarEstadoProyectoUseCase(proyectoRepository);
    }
    @Bean
    public ObtenerAvanceProyectoUseCase obtenerAvanceProyectoUseCase(ProyectoRepository proyectoRepository, TareaRepository tareaRepository){
        return new ObtenerAvanceProyectoUseCase(proyectoRepository, tareaRepository);
    }
    @Bean
    public ListarTareasProyectoUseCase listarTareasProyectoUseCase(ProyectoRepository proyectoRepository, TareaRepository tareaRepository){
        return new ListarTareasProyectoUseCase(proyectoRepository,tareaRepository);
    }
}
