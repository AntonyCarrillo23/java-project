package com.proyectos.api_gestion_proyectos.infrastructure.persistence.adapter;

import com.proyectos.api_gestion_proyectos.domain.model.Usuario;
import com.proyectos.api_gestion_proyectos.domain.repository.UsuarioRepository;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.UsuarioEntity;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.jpa.UsuarioJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryImpl(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity=toEntity(usuario);
        return toDomain(usuarioJpaRepository.save(entity));
    }

    @Override
    public Optional<Usuario> findById(Long id) {

        return usuarioJpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioJpaRepository.findByEmail(email).map(this::toDomain);
    }

    @Override
    public boolean existsById(Long id) {
        return usuarioJpaRepository.existsById(id);
    }


    private UsuarioEntity toEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setNombre(usuario.getNombreUsuario());
        entity.setApellido(usuario.getApellidoUsuario());
        entity.setEmail(usuario.getEmail());
        entity.setPassword(usuario.getPassword());
        entity.setRol(usuario.getRol());
        entity.setActivo(usuario.isActivo());
        return entity;
    }

    private Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRol(),
                entity.isActivo()
        );
    }
}
