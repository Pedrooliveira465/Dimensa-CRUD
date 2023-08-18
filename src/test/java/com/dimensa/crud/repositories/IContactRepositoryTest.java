package com.dimensa.crud.repositories;

import com.dimensa.crud.entities.Contact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IContactRepositoryTest {

    @Autowired
    private IContactRepository contactRepository;

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact();
        contact.setName("John Doe");
        contact.setEmail("john.doe@example.com");
    }

    @AfterEach
    void tearDown() {
        contactRepository.deleteAll();
    }

    @Test
    void shouldSaveContact() {
        Contact savedContact = contactRepository.save(contact);
        assertNotNull(savedContact);
    }

    @Test
    void shouldFindContactById() {
        Contact savedContact = contactRepository.save(contact);
        assertTrue(contactRepository.findById(savedContact.getId()).isPresent());
    }

    @Test
    void shouldUpdateContact() {
        Contact savedContact = contactRepository.save(contact);
        savedContact.setEmail("john.new@example.com");
        Contact updatedContact = contactRepository.save(savedContact);
        assertEquals("john.new@example.com", updatedContact.getEmail());
    }

    @Test
    void shouldDeleteContact() {
        Contact savedContact = contactRepository.save(contact);
        contactRepository.deleteById(savedContact.getId());
        assertFalse(contactRepository.findById(savedContact.getId()).isPresent());
    }
}
