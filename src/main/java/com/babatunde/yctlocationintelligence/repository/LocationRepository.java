package com.babatunde.yctlocationintelligence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babatunde.yctlocationintelligence.model.YctLocations;

@Repository
public interface LocationRepository extends JpaRepository<YctLocations, Long> {

}
