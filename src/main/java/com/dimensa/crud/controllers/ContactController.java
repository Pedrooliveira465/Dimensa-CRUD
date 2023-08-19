package com.dimensa.crud.controllers;

import com.dimensa.crud.dto.ContactDto;
import com.dimensa.crud.services.IContactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
@Tag(name = "Contacts Controller", description = "Handle all operations related to Contacts")
public class ContactController extends AbstractCrudController<ContactDto> {

    public ContactController(IContactService contactService) { super(contactService); }

}
