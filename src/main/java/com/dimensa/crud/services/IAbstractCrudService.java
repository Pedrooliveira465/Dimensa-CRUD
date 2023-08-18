package com.dimensa.crud.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface IAbstractCrudService<D> {
    D save(D dto);

    Optional<D> findById(UUID id);

    Page<D> findAll(Pageable pageable);

    D update(UUID id, D dto);

    void deleteById(UUID id);

}
