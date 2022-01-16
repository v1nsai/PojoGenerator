package com.doctor_ew.pojo_generator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Person {
    private List<Address> previousAddresses;
    private String firstName;
    private String lastName;
    private int numberOfDogs;
    private Address address;
}
