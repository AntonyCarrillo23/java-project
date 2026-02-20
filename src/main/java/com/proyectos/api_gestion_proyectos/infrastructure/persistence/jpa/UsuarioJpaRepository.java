package com.proyectos.api_gestion_proyectos.infrastructure.persistence.jpa;

import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity,Long> {
    Optional<UsuarioEntity> findByEmail(String email);
}
