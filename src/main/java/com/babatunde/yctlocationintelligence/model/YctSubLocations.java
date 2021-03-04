package com.babatunde.yctlocationintelligence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.babatunde.yctlocationintelligence.utilities.ConverterUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class YctSubLocations {

	@Id
	@GeneratedValue(generator = "subloc_cat_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "subloc_cat_seq")
	private long id;

	@NotNull(message="Please provide a name of the location")
	private String name;

	private String description;

	@JsonIgnore
	private Date dateAdded = new Date();

	@JsonIgnore
	private String addedBy;

	@ManyToMany
	@JoinTable(name = "yctsub_locations_joiner",
    joinColumns = @JoinColumn(name = "sub_id"),
    inverseJoinColumns = @JoinColumn(name="loc_id")
)
	private List<YctLocations> location;

	
	private boolean isApproved=false;

	private String approvedBy;

	public YctSubLocations(String name, String description, String addedBy,List<YctLocations> location) {
		this.name = name;
		this.description = description;
		this.addedBy = addedBy;
		this.dateAdded = new Date();
		this.location = location;
	}
	
	public YctSubLocations(List<YctLocations> location) {
		YctLocations main = location.get(0);
		this.name=main.getName();
		this.description=main.getDescription();
		this.location = location;		
	}
	
	@Override
	public String toString() {
		return ConverterUtils.toJson(this);
	}

}
