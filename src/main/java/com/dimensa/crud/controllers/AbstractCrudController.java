package com.dimensa.crud.controllers;

import com.dimensa.crud.dto.BaseDto;
import com.dimensa.crud.services.IAbstractCrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Entity created"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @Operation(summary = "Create a new entity", description = "Creates a new entity with the given information")
    public ResponseEntity<D> create(@RequestBody @Valid D dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Entity not found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @Operation(summary = "Find entity by ID", description = "Finds and returns an entity with the given ID")
    public ResponseEntity<D> findById(@PathVariable UUID id) {
        return service.findById(id)
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Page not found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @Operation(summary = "List all entities", description = "Returns a list of all entities in a paginated format")
    public ResponseEntity<Page<D>> findAll(Pageable pageable) {
        Page<D> dtos = service.findAll(pageable);
        return dtos.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity updated"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @Operation(summary = "List all entities", description = "Returns a list of all entities in a paginated format")
    public ResponseEntity<D> partialUpdate(@PathVariable UUID id, @RequestBody @Valid D dto) {
        D updatedDto = service.update(id, dto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entity updated"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @Operation(summary = "Update an entity", description = "Updates an existing entity with the given information")
    public ResponseEntity<D> update(@PathVariable UUID id, @RequestBody @Valid D dto) {
        D updatedDto = service.update(id, dto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Entity not found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @Operation(summary = "Delete an entity", description = "Deletes an entity with the given ID")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
