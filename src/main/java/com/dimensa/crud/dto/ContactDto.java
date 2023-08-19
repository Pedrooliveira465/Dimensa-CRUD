package com.dimensa.crud.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactDto extends BaseDto {

    @NotBlank(message = "The name field cannot be empty")
    private String name;

    @NotBlank(message = "The email field cannot be empty")
    private String email;

    @NotBlank(message = "The phone field cannot be empty")
    private String phone;

    @NotNull(message = "The birthdayDate field cannot be empty")
    private Date birthdayDate;

    @Valid
    private List<AddressDto> addresses;
}
