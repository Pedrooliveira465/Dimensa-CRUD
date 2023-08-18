package com.dimensa.crud.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import com.dimensa.crud.entities.Address;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class IAddressRepositoryTest {

    @Autowired
    private IAddressRepository addressRepository;

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address();
        address.setStreet("123 Main St");
        address.setNumber("101");
        address.setZipcode("12345");
    }

    @AfterEach
    void tearDown() {
        addressRepository.deleteAll();
    }

    @Test
    void shouldSaveAddress() {
        Address savedAddress = addressRepository.save(address);
        assertNotNull(savedAddress);
    }

    @Test
    void shouldFindAddressById() {
        Address savedAddress = addressRepository.save(address);
        assertTrue(addressRepository.findById(savedAddress.getId()).isPresent());
    }

    @Test
    void shouldUpdateAddress() {
        Address savedAddress = addressRepository.save(address);
        savedAddress.setNumber("102");
        Address updatedAddress = addressRepository.save(savedAddress);
        assertEquals("102", updatedAddress.getNumber());
    }

    @Test
    void shouldDeleteAddress() {
        Address savedAddress = addressRepository.save(address);
        addressRepository.deleteById(savedAddress.getId());
        assertFalse(addressRepository.findById(savedAddress.getId()).isPresent());
    }
}
