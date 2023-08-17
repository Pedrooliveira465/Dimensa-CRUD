package com.dimensa.crud.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Address extends  BaseEntity{

    private String street;
    private String number;
    private String zipcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Contact contact;

}
