package com.dimensa.crud.services;

import com.dimensa.crud.core.mappers.interfaces.IGenericMapper;
import com.dimensa.crud.dto.AddressDto;
import com.dimensa.crud.entities.Address;
import com.dimensa.crud.repositories.IAddressRepository;
import com.dimensa.crud.services.impl.AddressService;
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
public class AddressServiceTest {

    @Mock
    private IAddressRepository addressRepository;

    @Mock
    private IGenericMapper<AddressDto, Address> addressIGenericMapper;

    @InjectMocks
    private AddressService addressService;

    private Address address;

    private AddressDto addressDto;

    @BeforeEach
    void setUp() {
        address = new Address();
        addressDto = new AddressDto();
    }

    @Test
    void shouldSaveAddress() {
        when(addressIGenericMapper.toEntity(addressDto)).thenReturn(address);
        when(addressRepository.save(address)).thenReturn(address);
        addressService.save(addressDto);
        verify(addressRepository).save(address);
    }

    @Test
    void shouldFindAddressById() {
        UUID id = UUID.randomUUID();
        when(addressRepository.findById(id)).thenReturn(Optional.of(address));
        addressService.findById(id);
        verify(addressRepository).findById(id);
    }

    @Test
    void shouldUpdateAddress() {
        UUID id = UUID.randomUUID();
        when(addressRepository.existsById(id)).thenReturn(true);
        when(addressIGenericMapper.toEntity(addressDto)).thenReturn(address);
        when(addressRepository.save(address)).thenReturn(address);
        addressService.update(id, addressDto);
        verify(addressRepository).save(address);
    }

    @Test
    void shouldDeleteAddress() {
        UUID id = UUID.randomUUID();
        when(addressRepository.existsById(id)).thenReturn(true);
        addressService.deleteById(id);
        verify(addressRepository).deleteById(id);
    }

}
