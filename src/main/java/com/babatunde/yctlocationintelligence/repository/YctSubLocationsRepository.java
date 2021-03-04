package com.babatunde.yctlocationintelligence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.babatunde.yctlocationintelligence.model.YctSubLocations;

@Repository
public interface YctSubLocationsRepository extends JpaRepository<YctSubLocations, Long> {

	@Query(nativeQuery = true,value = "SELECT * FROM yct_sub_locations where name ILIKE %?1%")
	public List<YctSubLocations> findByNameLike(String name);
	
	
}
