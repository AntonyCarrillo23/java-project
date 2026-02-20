package com.proyectos.api_gestion_proyectos.domain.repository;

import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoRepository {
    Proyecto save(Proyecto proyecto);
    Optional<Proyecto> findById(Long id);
    List<Proyecto> findAll();
}
