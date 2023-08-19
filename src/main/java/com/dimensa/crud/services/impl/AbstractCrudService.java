package com.dimensa.crud.services.impl;

import com.dimensa.crud.core.mappers.interfaces.IGenericMapper;
import com.dimensa.crud.dto.BaseDto;
import com.dimensa.crud.entities.BaseEntity;
import com.dimensa.crud.services.IAbstractCrudService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class AbstractCrudService<D extends BaseDto, E extends BaseEntity> implements IAbstractCrudService<D> {

    private final JpaRepository<E, UUID> repository;
    private final IGenericMapper<D, E> mapper;

    @Transactional
    public D save(D dto) {
        E entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public Optional<D> findById(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        return repository.findById(id).map(mapper::toDto);
    }

    public Page<D> findAll(Pageable pageable) {
        Page<E> entities = repository.findAll(pageable);
        return entities.map(mapper::toDto);
    }

    @Transactional
    public D update(UUID id, D dto) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        E entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Transactional
    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        repository.deleteById(id);
    }
}
