package com.dimensa.crud.controllers;

import com.dimensa.crud.dto.AddressDto;
import com.dimensa.crud.services.IAddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController extends AbstractCrudController<AddressDto> {

    public AddressController(IAddressService addressService) { super(addressService); }

}
