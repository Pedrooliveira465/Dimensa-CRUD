package com.dimensa.crud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto extends BaseDto {

    @NotBlank(message = "The street field cannot be empty")
    private String street;

    @NotBlank(message = "The number field cannot be empty")
    private String number;

    @NotBlank(message = "The zipcode field cannot be empty")
    private String zipcode;
}
