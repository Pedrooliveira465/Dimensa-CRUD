package com.dimensa.crud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class BaseDto {
    private UUID id;
}
