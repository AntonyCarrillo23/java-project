package com.proyectos.api_gestion_proyectos.infrastructure.config;

import com.proyectos.api_gestion_proyectos.aplication.usecase.usuario.*;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioUseCaseConfig {

    //Usuarios
    @Bean
    public CrearUsuarioUseCase crearUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new CrearUsuarioUseCase(usuarioRepository);
    }

    @Bean
    public ListarUsuariosUseCase listarUsuariosUseCase(UsuarioRepository usuarioRepository) {
        return new ListarUsuariosUseCase(usuarioRepository);
    }

    @Bean
    public CambiarEstadoUsuarioUseCase cambiarEstadoUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new CambiarEstadoUsuarioUseCase(usuarioRepository);
    }
    @Bean
    public ListarUsuarioByIdUseCase listarUsuarioByIdUseCase(UsuarioRepository usuarioRepository){
        return  new ListarUsuarioByIdUseCase(usuarioRepository);
    }

    @Bean
    public ActualizarUsuarioUseCase actualizarUsuarioUseCase(UsuarioRepository usuarioRepository){
        return new ActualizarUsuarioUseCase(usuarioRepository);
    }
    @Bean EliminarUsuarioUseCase eliminarUsuarioUseCase(UsuarioRepository usuarioRepository){
        return  new EliminarUsuarioUseCase(usuarioRepository);
    }

}
