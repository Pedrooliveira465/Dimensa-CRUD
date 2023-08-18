package com.dimensa.crud.services.impl;
import com.dimensa.crud.core.mappers.interfaces.IGenericMapper;
import com.dimensa.crud.dto.ContactDto;
import com.dimensa.crud.entities.Contact;
import com.dimensa.crud.repositories.IContactRepository;
import com.dimensa.crud.services.IContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactService extends AbstractCrudService<ContactDto, Contact> implements IContactService {
    public ContactService(IContactRepository repository, IGenericMapper<ContactDto, Contact> mapper) {
        super(repository, mapper);
    }
}