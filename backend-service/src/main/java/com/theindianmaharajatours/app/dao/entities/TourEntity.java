package com.theindianmaharajatours.app.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="Tour")
public class TourEntity {

	@Id
    @Column(name="tourid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tourId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cities",columnDefinition = "varchar(1000)")
	private String cities;
	
	@Column(name="overview",columnDefinition="TEXT")
	private String overview;
	
	@Column(name="thumbnail")
    @Lob
    private Blob thumbnail;
	
	@Column(name="thumbnailfilename",columnDefinition = "varchar(1000)")
    private String thumbnailFilename;
	
	@Column(name="created",columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date created;
	
	@Column(name="duration",columnDefinition = "varchar(1000)")
	private String duration;

	@Column(name="stateid")
	private Long stateId;
	
	@Column(name="statename")
	private String stateName;
}
