package com.theindianmaharajatours.app.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Itinerary")
public class ItineraryEntity {

	@Id
    @Column(name="itineraryid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long itineraryId;
	
    @Column(name="tourid",columnDefinition = "INT(11)")
	private Long tourId;
	
    @Column(name="name",columnDefinition = "varchar(500)")
	private String name;
    
    @Column(name="daynumber",columnDefinition = "INT(11)")
	private Integer dayNumber;
    
    @Column(name="daycity",columnDefinition = "varchar(500)")
	private String dayCity;
    
    @Column(name="daydetails",columnDefinition="TEXT")
   	private String dayDetails;


}
