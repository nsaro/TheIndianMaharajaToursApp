package com.theindianmaharajatours.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Destination
{
    private int id;
    private String name;
    private String info;
    private String region;
    private String photo;
}
