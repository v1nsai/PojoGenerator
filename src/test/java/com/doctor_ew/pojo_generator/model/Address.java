package com.doctor_ew.pojo_generator.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
