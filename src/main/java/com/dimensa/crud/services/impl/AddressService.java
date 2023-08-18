package com.dimensa.crud.services.impl;

import com.dimensa.crud.core.mappers.interfaces.IGenericMapper;
import com.dimensa.crud.dto.AddressDto;
import com.dimensa.crud.entities.Address;
import com.dimensa.crud.repositories.IAddressRepository;
import com.dimensa.crud.services.IAddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractCrudService<AddressDto, Address> implements IAddressService {

    public AddressService(IAddressRepository repository, IGenericMapper<AddressDto, Address> mapper) {
        super(repository, mapper);
    }

}
