package com.theindianmaharajatours.app.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name="State")
public class State {
    
	@Id
    @Column(name="stateid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long stateId;

	@Column(name="name")
    private String name;
 
    @Column(name="thumbnaildescription")
    private String thumbnailDescription;
 
    @Column(name="thumbnailfilename")
    private String thumbnailFilename;
 
    @Column(name="region")
    private String region;
    
	@Column(name="thumbnail")
    @Lob
    private Blob thumbnail;
	
	@Column(name="bigimage")
    @Lob
    private Blob bigImage;
    
	@Column(name="bigimagefilename",columnDefinition = "varchar(500)")
    private String bigImageFilename;
	
     
    @Column(name="created",columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date created;
	
    @Column(name="descriptionpara1",columnDefinition="TEXT")
    private String descriptionParagraphOne;
     
    @Column(name="descriptionpara2",columnDefinition="TEXT")
    private String descriptionParagraphTwo;


}
