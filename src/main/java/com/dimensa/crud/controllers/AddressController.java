package com.dimensa.crud.controllers;

import com.dimensa.crud.dto.AddressDto;
import com.dimensa.crud.services.IAddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
@Tag(name = "Address Controller", description = "Handle all operations related to Addresses")
public class AddressController extends AbstractCrudController<AddressDto> {

    public AddressController(IAddressService addressService) { super(addressService); }

}
