package com.proyectos.api_gestion_proyectos.domain.repository;

import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    List<Usuario> findAll();
    Optional<Usuario>findByEmail(String email);
    boolean existsById(Long id);
}
