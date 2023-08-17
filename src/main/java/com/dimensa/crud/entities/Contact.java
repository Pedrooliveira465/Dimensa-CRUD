package com.dimensa.crud.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Contact extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    private Date birthdayDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;
}