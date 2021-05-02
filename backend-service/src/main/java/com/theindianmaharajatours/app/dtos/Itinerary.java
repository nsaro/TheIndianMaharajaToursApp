package com.theindianmaharajatours.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Itinerary
{
	private int id;
	private Tour tour;
	private String overviewParagraphOne;
	private String overviewParagraphTwo;
	private List<String> highList;
	private List<String> tourPhotos;
	private List<String> itineraries;
}
