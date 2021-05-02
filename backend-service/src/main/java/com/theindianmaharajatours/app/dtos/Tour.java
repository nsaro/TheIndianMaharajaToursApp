package com.theindianmaharajatours.app.dtos;

import com.theindianmaharajatours.app.dtos.Enum.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Tour
{
    private long id;
    private String name;
    private Enum.States states;
    private List<City> cities;
    private String title;
    private String overview;
    private String thumbnail;
    private String duration;
}
