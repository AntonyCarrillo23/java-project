package com.proyectos.api_gestion_proyectos.infrastructure.persistence.jpa;

import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaJpaRepository extends JpaRepository<TareaEntity, Long> {

    long countByIdProyectoId(Long idProyecto);
    long countByIdProyectoIdAndEstado(Long idProyecto, EstadoTarea estado);
    List<TareaEntity> findByIdProyectoId(Long idProyecto);
}
