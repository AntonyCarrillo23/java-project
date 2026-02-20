package com.proyectos.api_gestion_proyectos.infrastructure.persistence.jpa;

import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.ProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoJpaRepository extends JpaRepository<ProyectoEntity, Long> {
}
