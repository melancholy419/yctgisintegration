package com.babatunde.yctlocationintelligence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.babatunde.yctlocationintelligence.model.YctLocations;
import com.babatunde.yctlocationintelligence.model.YctSubLocations;
import com.babatunde.yctlocationintelligence.response.ApiResponse;
import com.babatunde.yctlocationintelligence.service.LocationService;
import com.babatunde.yctlocationintelligence.service.YctSubLocationsService;

@RestController
@RequestMapping("/locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	
	@GetMapping
	public ApiResponse getAllLocations() {
		return locationService.getAllLocations();
	}
	
	@PostMapping
	public ApiResponse addNewLocation(@RequestBody YctLocations location) {
		return locationService.addNewLocation(location);
	}
	
	@PutMapping
	public ApiResponse updateLocation(@RequestBody YctLocations location) {
		return locationService.updateLocation(location);
	}
	
	@GetMapping("/find")
	public ApiResponse findLocationById(@RequestParam long id) {
		return locationService.findLocation(id);
	}
	
	@GetMapping("/delete")
	public ApiResponse deleteById(@RequestParam long id) {
		return locationService.deleteLocation(id);
	}
	
	@GetMapping("/by-category")
	public ApiResponse findAllByCategory(@RequestParam long categoryId) {
		return locationService.findBycategory(categoryId);
	}
	
	
	
	
   

}
