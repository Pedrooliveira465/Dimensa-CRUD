package com.dimensa.crud.controllers;

import com.dimensa.crud.dto.BaseDto;
import com.dimensa.crud.services.IAbstractCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
public abstract class AbstractCrudController<D extends BaseDto> {

    private final IAbstractCrudService<D> service;

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable UUID id) {
        return service.findById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Page<D>> findAll(Pageable pageable) {
        Page<D> dtos = service.findAll(pageable);
        return dtos.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<D> partialUpdate(@PathVariable UUID id, @RequestBody D dto) {
        D updatedDto = service.update(id, dto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable UUID id, @RequestBody D dto) {
        D updatedDto = service.update(id, dto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
