package com.proyectos.api_gestion_proyectos.presentation.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public class AsignarUsuarioRequest {
    @NotNull
    private Long idUsuario;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
