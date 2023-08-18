package com.dimensa.crud.core.mappers.interfaces;

public interface IGenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}
