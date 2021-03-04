package com.babatunde.yctlocationintelligence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.babatunde.yctlocationintelligence.utilities.ConverterUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class YctLocations {

	@Id
	@GeneratedValue(generator = "loc_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "loc_seq")
	private long id;

	private double longitude;

	private double latitude;

	private String name;

	private String description;
	
	private String abbreviation;

	@JsonIgnore
	private Date dateAdded = new Date();

	@JsonIgnore
	private String addedBy;

	@ManyToMany
	private List<LocationCategory> categories;

	private boolean isApproved=true;

	private String approvedBy;

	public YctLocations(double longitude, double latitude, String name, String description,String abbreviation ) {

		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.description = description;
		this.addedBy = "SYSTEM";
		this.abbreviation=abbreviation;
		this.dateAdded = new Date();
	}

	@Override
	public String toString() {
		return ConverterUtils.toJson(this);
	}

}
