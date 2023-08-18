package com.dimensa.crud.core.mappers;
import com.dimensa.crud.core.mappers.interfaces.IGenericMapper;
import com.dimensa.crud.dto.ContactDto;
import com.dimensa.crud.entities.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper implements IGenericMapper<ContactDto, Contact> {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ContactDto toDto(Contact contact) {
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public Contact toEntity(ContactDto contactDto) {
        return modelMapper.map(contactDto, Contact.class);
    }
}
