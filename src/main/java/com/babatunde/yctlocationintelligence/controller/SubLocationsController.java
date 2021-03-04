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

import com.babatunde.yctlocationintelligence.model.YctSubLocations;
import com.babatunde.yctlocationintelligence.response.ApiResponse;
import com.babatunde.yctlocationintelligence.service.YctSubLocationsService;

@RestController
@RequestMapping("/sublocations")
public class SubLocationsController {
	
	@Autowired
	private YctSubLocationsService subLocationService;
	
	@GetMapping
	public ApiResponse findAllSubLocations() {
		return subLocationService.findAllSubLocations();
	}
	
	@GetMapping("/find")
	public ApiResponse findAllSublocationsByName(@RequestParam String query) {
		return subLocationService.findAllSubLocationsByName(query);
	}
	
	@PostMapping("/add")
	public ApiResponse addNewSubLocation(@RequestBody YctSubLocations location) {
		return subLocationService.addNewSubLocation(location);
	}
	
	@PutMapping("/update")
	public ApiResponse updateSubLocation(@RequestBody YctSubLocations location) {
		return subLocationService.updateSubLocation(location);
	}
	
	@GetMapping("/fetch/{id}")
	public ApiResponse findById(@PathVariable long id) {
		return subLocationService.findById(id);
	}
	

}
