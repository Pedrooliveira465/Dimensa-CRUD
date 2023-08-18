package com.dimensa.crud.controllers;

import com.dimensa.crud.dto.ContactDto;
import com.dimensa.crud.services.IContactService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
public class ContactController extends AbstractCrudController<ContactDto> {

    public ContactController(IContactService contactService) { super(contactService); }

}
