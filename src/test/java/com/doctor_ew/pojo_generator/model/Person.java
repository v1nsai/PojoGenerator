package com.doctor_ew.pojo_generator.model;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private List<Address> previousAddresses;
    private String firstName;
    private String lastName;
    private int numberOfDogs;
    private Address address;
}
