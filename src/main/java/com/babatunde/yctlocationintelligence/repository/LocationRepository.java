package com.babatunde.yctlocationintelligence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babatunde.yctlocationintelligence.model.LocationCategory;
import com.babatunde.yctlocationintelligence.model.YctLocations;

@Repository
public interface LocationRepository extends JpaRepository<YctLocations, Long> {

	public List<YctLocations> findAllByCategories(LocationCategory category);
	
	public List<YctLocations> findAllByIsApproved(boolean isApproved);
	
	@Query(nativeQuery = true,value = "SELECT * FROM yct_locations where name ILIKE %?1%")
	public List<YctLocations> findAllByNameLike(String query);
	
}
