package com.dimensa.crud.controllers;

import com.dimensa.crud.dto.ContactDto;
import com.dimensa.crud.services.IContactService;
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

@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IContactService contactService;

    private ContactDto contactDto;

    @BeforeEach
    void setUp() {
        contactDto = new ContactDto();
        contactDto.setName("John Doe");
        contactDto.setEmail("john.doe@example.com");
    }

    @Test
    void shouldCreateContact() throws Exception {
        when(contactService.save(any(ContactDto.class))).thenReturn(contactDto);
        mockMvc.perform(post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(contactDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldGetContactById() throws Exception {
        UUID id = UUID.randomUUID();
        when(contactService.findById(id)).thenReturn(Optional.of(contactDto));
        mockMvc.perform(get("/api/contacts/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateContact() throws Exception {
        UUID id = UUID.randomUUID();
        when(contactService.update(eq(id), any(ContactDto.class))).thenReturn(contactDto);
        mockMvc.perform(put("/api/contacts/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(contactDto)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteContact() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(contactService).deleteById(id);
        mockMvc.perform(delete("/api/contacts/" + id))
                .andExpect(status().isNoContent());
    }
}
