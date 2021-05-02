package com.theindianmaharajatours.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class State
{
	private long id;
	private String name;
	private String photo;
	private String para1;
	private String para2;
	private List<Tour> tours = new ArrayList<>();
}
