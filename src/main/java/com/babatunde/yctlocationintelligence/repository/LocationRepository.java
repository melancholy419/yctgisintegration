package com.babatunde.yctlocationintelligence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babatunde.yctlocationintelligence.model.LocationCategory;
import com.babatunde.yctlocationintelligence.model.YctLocations;

@Repository
public interface LocationRepository extends JpaRepository<YctLocations, Long> {

	public List<YctLocations> findAllByCategories(LocationCategory category);
	
}
