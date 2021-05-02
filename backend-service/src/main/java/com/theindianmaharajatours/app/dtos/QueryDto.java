package com.theindianmaharajatours.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class QueryDto {
    private String name;
    private String subject;
    private String email;
    private String phone;
    private String text;
    private long tourId;
    private String budgetSelection;
    private String budget;
    private String accommodation;
    private String country;
    private int numberOfPassenger;
    private String selectedCar;
}
