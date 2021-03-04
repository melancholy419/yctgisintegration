package com.babatunde.yctlocationintelligence.service;

import com.babatunde.yctlocationintelligence.model.YctSubLocations;
import com.babatunde.yctlocationintelligence.response.ApiResponse;

public interface YctSubLocationsService {
	
	public ApiResponse addNewSubLocation(YctSubLocations subLocation);
	
	public ApiResponse updateSubLocation(YctSubLocations subLocation);
	
	public ApiResponse findById(long id);
	
	public ApiResponse findAllSubLocations();
	
	public ApiResponse deleteById(long id);

	public ApiResponse findAllSubLocationsByName(String query);
	
	

}
