package com.dimensa.crud.services;

import com.dimensa.crud.core.mappers.interfaces.IGenericMapper;
import com.dimensa.crud.dto.ContactDto;
import com.dimensa.crud.entities.Contact;
import com.dimensa.crud.repositories.IContactRepository;
import com.dimensa.crud.services.impl.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private IContactRepository contactRepository;
    @Mock
    private IGenericMapper<ContactDto, Contact> contactIGenericMapper;

    @InjectMocks
    private ContactService contactService;

    private Contact contact;
    private ContactDto contactDto;

    @BeforeEach
    void setUp() {
        contact = new Contact();
        contactDto = new ContactDto();
    }

    @Test
    void shouldSaveContact() {
        when(contactIGenericMapper.toEntity(contactDto)).thenReturn(contact);
        when(contactRepository.save(contact)).thenReturn(contact);
        contactService.save(contactDto);
        verify(contactRepository).save(contact);
    }

    @Test
    void shouldFindContactById() {
        UUID id = UUID.randomUUID();
        when(contactRepository.findById(id)).thenReturn(Optional.of(contact));
        contactService.findById(id);
        verify(contactRepository).findById(id);
    }

    @Test
    void shouldUpdateContact() {
        UUID id = UUID.randomUUID();
        when(contactRepository.existsById(id)).thenReturn(true);
        when(contactIGenericMapper.toEntity(contactDto)).thenReturn(contact);
        when(contactRepository.save(contact)).thenReturn(contact);
        contactService.update(id, contactDto);
        verify(contactRepository).save(contact);
    }

    @Test
    void shouldDeleteContact() {
        UUID id = UUID.randomUUID();
        when(contactRepository.existsById(id)).thenReturn(true);
        contactService.deleteById(id);
        verify(contactRepository).deleteById(id);
    }
}
