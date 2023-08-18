package com.dimensa.crud.controllers;

import com.dimensa.crud.dto.AddressDto;
import com.dimensa.crud.services.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAddressService addressService;

    private AddressDto addressDto;

    @BeforeEach
    void setUp() {
        addressDto = new AddressDto();
        addressDto.setStreet("123 Main St");
        addressDto.setNumber("101");
        addressDto.setZipcode("12345");
    }

    @Test
    void shouldCreateAddress() throws Exception {
        when(addressService.save(any(AddressDto.class))).thenReturn(addressDto);
        mockMvc.perform(post("/api/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addressDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldGetAddressById() throws Exception {
        UUID id = UUID.randomUUID();
        when(addressService.findById(id)).thenReturn(Optional.of(addressDto));
        mockMvc.perform(get("/api/addresses/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateAddress() throws Exception {
        UUID id = UUID.randomUUID();
        when(addressService.update(eq(id), any(AddressDto.class))).thenReturn(addressDto);
        mockMvc.perform(put("/api/addresses/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(addressDto)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteAddress() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(addressService).deleteById(id);
        mockMvc.perform(delete("/api/addresses/" + id))
                .andExpect(status().isNoContent());
    }
}

