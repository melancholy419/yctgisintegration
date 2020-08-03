package com.babatunde.yctlocationintelligence.service;

import com.babatunde.yctlocationintelligence.model.YctLocations;
import com.babatunde.yctlocationintelligence.response.ApiResponse;

public interface LocationService {
	
	public ApiResponse getAllLocations();
	
	public ApiResponse addNewLocation(YctLocations location);
	
	public ApiResponse updateLocation(YctLocations location);
	
	public ApiResponse deleteLocation(long locationId);
	
	public ApiResponse findLocation(long locationId);
	
	public ApiResponse findBycategory(long categoryId);
	
	
	

}
