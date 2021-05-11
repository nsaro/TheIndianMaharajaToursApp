package com.theindianmaharajatours.app.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

@Getter
@Setter
@Entity
@Table(name="TourSlide")
public class TourSlideEntity {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="tourid",columnDefinition = "INT(11)")
	private Long tourId;
	
    @Column(name="name",columnDefinition = "varchar(500)")
	private String name;
    
    @Column(name="tourslider")
    @Lob
    private Blob tourSlider;
	
	@Column(name="toursliderfilename",columnDefinition = "varchar(1000)")
    private String tourSlideFilename;
}
