package com.proyectos.api_gestion_proyectos.infrastructure.persistence.adapter;

import com.proyectos.api_gestion_proyectos.domain.model.EstadoTarea;
import com.proyectos.api_gestion_proyectos.domain.model.Tarea;
import com.proyectos.api_gestion_proyectos.domain.repository.TareaRepository;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.ProyectoEntity;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.TareaEntity;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.entity.UsuarioEntity;
import com.proyectos.api_gestion_proyectos.infrastructure.persistence.jpa.TareaJpaRepository;
import com.proyectos.api_gestion_proyectos.presentation.rest.mapper.TareaRestMapper;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TareaRepositoryImpl implements TareaRepository {
    private final TareaJpaRepository tareaJpaRepository;
    private final EntityManager entityManager;

    public TareaRepositoryImpl(TareaJpaRepository tareaJpaRepository, EntityManager entityManager) {
        this.tareaJpaRepository = tareaJpaRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Tarea save(Tarea tarea) {
        TareaEntity entity=toEntity(tarea);
        return toDomain(tareaJpaRepository.save(entity));
    }

    @Override
    public Optional<Tarea> findById(Long id) {
        return tareaJpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Tarea> findAll() {
        return tareaJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public long contarPorProyecto(Long idProyecto) {
        return tareaJpaRepository.countByIdProyectoId(idProyecto);
    }

    @Override
    public long contarPorProyectoYEstado(Long idProyecto, EstadoTarea estado) {
        return tareaJpaRepository.countByIdProyectoIdAndEstado(idProyecto,estado);
    }

    @Override
    public List<Tarea> listarPorProyecto(Long idProyecto) {
        /*return tareaJpaRepository.findById(idProyecto)
                .stream()
                .map(this::toDomain)
                .toList();*/
        List<TareaEntity> tareas = tareaJpaRepository.findByIdProyectoId(idProyecto);

        return tareas.stream()
                .map(this::toDomain)
                .toList();
    }

    private TareaEntity toEntity(Tarea tareaDomain){
        TareaEntity entity=new TareaEntity();
        entity.setIdTarea(tareaDomain.getIdTarea());
        // USANDO EL ENFOQUE LAZY:
        // Obtenemos una referencia (proxy) usando solo el ID del dominio
        if (tareaDomain.getIdProyecto() != null) {
            entity.setIdProyecto(entityManager.getReference(ProyectoEntity.class, tareaDomain.getIdProyecto()));
        }

        if (tareaDomain.getIdUsuario() != null) {
            entity.setIdUsuario(entityManager.getReference(UsuarioEntity.class, tareaDomain.getIdUsuario()));
        }
        entity.setTitulo(tareaDomain.getTitulo());
        entity.setDescripcion(tareaDomain.getDescripcion());
        entity.setFechaVencimiento(tareaDomain.getFechaVencimiento());
        if (tareaDomain.getEstado() != null) {
            entity.setEstado(EstadoTarea.valueOf(tareaDomain.getEstado().name()));
        }
        return  entity;
    }

    private Tarea toDomain(TareaEntity tareaEntity){
        return new Tarea(
                tareaEntity.getIdTarea(),
                tareaEntity.getIdProyecto().getId(),
                tareaEntity.getIdUsuario().getId(),
                tareaEntity.getTitulo(),
                tareaEntity.getDescripcion(),
                EstadoTarea.valueOf(tareaEntity.getEstado().name()),
                tareaEntity.getFechaVencimiento()
        );
    }
}
