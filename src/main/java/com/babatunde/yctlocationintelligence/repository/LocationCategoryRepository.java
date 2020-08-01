package com.babatunde.yctlocationintelligence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babatunde.yctlocationintelligence.model.LocationCategory;

@Repository
public interface LocationCategoryRepository extends JpaRepository<LocationCategory, Long> {

}
