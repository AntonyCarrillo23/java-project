package com.proyectos.api_gestion_proyectos.presentation.rest.exception;

import com.proyectos.api_gestion_proyectos.domain.exception.*;
import com.proyectos.api_gestion_proyectos.presentation.rest.dto.response.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Usuarios
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleUsuarioNoEncontrado(
            UsuarioNoEncontradoException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDto<>(
                        false,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(EmailRepetidoException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleEmailRepetido(
            EmailRepetidoException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponseDto<>(
                        false,
                        ex.getMessage(),
                        null
                ));
    }

    //Proyectos
    @ExceptionHandler(FechaFinException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleFechaFin(
            FechaFinException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiResponseDto<>(
                        false,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(ProyectoNoEncontradoException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleProyectoNoEncontrado(
            ProyectoNoEncontradoException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDto<>(
                        false,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(EstadoInvalidoException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleEstadoInvalido(
            EstadoInvalidoException ex)
    {
       return ResponseEntity.status(HttpStatus.CONFLICT)
               .body(new ApiResponseDto<>(
                       false,
                       ex.getMessage(),
                       null
               ));
    }
    //Tareas
    @ExceptionHandler(TareaNoEncontradaException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleTareaNoEncontrada(TareaNoEncontradaException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponseDto<>(
                        false,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDto<Void>> handleGeneral(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponseDto<>(
                        false,
                        "Error interno del servidor",
                        null
                ));
    }
}
