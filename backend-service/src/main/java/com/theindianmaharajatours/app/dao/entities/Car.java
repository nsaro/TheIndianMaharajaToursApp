package com.theindianmaharajatours.app.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;


@Getter
@Setter
@Entity
@Table(name="Car")
public class Car {

	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sittingCapacity")
	private int sittingCapacity;
	
	@Column(name="description")
	private String description;
	
	@Column(name="thumbnail")
    @Lob
    private Blob thumbnail;
	
	@Column(name="thumbnailfilename")
    private String thumbnailFilename;
	
}
