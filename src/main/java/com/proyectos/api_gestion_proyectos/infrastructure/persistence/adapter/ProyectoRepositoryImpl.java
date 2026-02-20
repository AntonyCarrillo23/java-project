package com.proyectos.api_gestion_proyectos.infrastructure.persistence.adapter;

import com.proyectos.api_gestion_proyectos.domain.model.Proyecto;
import com.proyectos.api_gestion_proyectos.domain.repository.ProyectoRepository;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.ProyectoEntity;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.jpa.ProyectoJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {
    private final ProyectoJpaRepository proyectoJpaRepository;

    public ProyectoRepositoryImpl(ProyectoJpaRepository proyectoJpaRepository) {
        this.proyectoJpaRepository = proyectoJpaRepository;
    }

    @Override
    public Proyecto save(Proyecto proyecto) {
        ProyectoEntity entity=toEntity(proyecto);
        return toDomain(proyectoJpaRepository.save(entity));
    }

    @Override
    public Optional<Proyecto> findById(Long id) {

        return proyectoJpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Proyecto> findAll() {
        return proyectoJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private ProyectoEntity toEntity(Proyecto proyectoDomain){
        ProyectoEntity entity=new ProyectoEntity();
        entity.setId(proyectoDomain.getId());
        entity.setNombre(proyectoDomain.getNombre());
        entity.setDescripcion(proyectoDomain.getDescripcion());
        entity.setFechaInicio(proyectoDomain.getFechaInicio());
        entity.setFechaFin(proyectoDomain.getFechaFin());
        entity.setEstado(proyectoDomain.getEstado());
        return  entity;
    }

    private Proyecto toDomain(ProyectoEntity entity){
        return new Proyecto (
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getEstado(),
                entity.getFechaInicio(),
                entity.getFechaFin()
                );
    }
}
