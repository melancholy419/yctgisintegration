package com.babatunde.yctlocationintelligence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.babatunde.yctlocationintelligence.utilities.ConverterUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LocationCategory {
	
	@Id
	@GeneratedValue(generator = "loc_cat_seq",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1,initialValue = 1,name = "loc_cat_seq")
	private long id;
	private String categoryName;
	private String description;
	@JsonIgnore
	private String createdBy;
	@JsonIgnore
	private Date createdDate = new Date();
	@JsonIgnore
	private String modifyBy;
	@JsonIgnore
	private Date lastModifiedDate=new Date();
	
	public LocationCategory(String categoryName,String description) {
		this.categoryName=categoryName;
		this.description=description;
		this.createdDate = new Date();
		this.lastModifiedDate=new Date();
	}

	@Override
	public String toString() {
		return ConverterUtils.toJson(this);
	}
}
