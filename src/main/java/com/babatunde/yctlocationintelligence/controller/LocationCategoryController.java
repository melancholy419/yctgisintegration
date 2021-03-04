package com.babatunde.yctlocationintelligence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.babatunde.yctlocationintelligence.model.LocationCategory;
import com.babatunde.yctlocationintelligence.response.ApiResponse;
import com.babatunde.yctlocationintelligence.service.LocationCategoryService;

@RestController
@RequestMapping("/location-category")
public class LocationCategoryController {
	
	@Autowired
	private LocationCategoryService categoryService;
	
	@GetMapping("/by-name")
	public ApiResponse fetchByCategoryName(@RequestParam String query) {
		return categoryService.queryLocations(query);
	}
	
	@GetMapping
	public ApiResponse getAllCategories() {
		return categoryService.getAllLocationCategory();
	}
	
	@PostMapping
	public ApiResponse addNewCategory(@RequestBody LocationCategory category) {
		return categoryService.saveNewCategory(category);
	}
	
	@PutMapping
	public ApiResponse updateCategory(@RequestBody LocationCategory category) {
		return categoryService.updateCategory(category);
	}
	
	@GetMapping("/find")
	public ApiResponse findCategoryById(@RequestParam long id) {
	  return categoryService.findCategoryById(id);
	}
	
	@GetMapping("/delete")
	public ApiResponse deleteCategoryById(@RequestParam long id) {
	  return categoryService.deleteCategoryById(id);
	}
	
	

}
