package com.babatunde.yctlocationintelligence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.babatunde.yctlocationintelligence.utilities.ConverterUtils;

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
	private String createdBy;
	private Date createdDate = new Date();
	private String modifyBy;
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
