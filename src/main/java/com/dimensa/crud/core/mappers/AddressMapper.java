package com.dimensa.crud.core.mappers;

import com.dimensa.crud.core.mappers.interfaces.IGenericMapper;
import com.dimensa.crud.dto.AddressDto;
import com.dimensa.crud.entities.Address;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements IGenericMapper<AddressDto, Address> {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public AddressDto toDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public Address toEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }
}
