package com.dimensa.crud.repositories;

import com.dimensa.crud.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IContactRepository extends JpaRepository<Contact, UUID> {
}
