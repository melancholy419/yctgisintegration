package com.babatunde.yctlocationintelligence.service;

import com.babatunde.yctlocationintelligence.model.LocationCategory;
import com.babatunde.yctlocationintelligence.response.ApiResponse;

public interface LocationCategoryService {
	
	public ApiResponse getAllLocationCategory();
	
	public ApiResponse saveNewCategory(LocationCategory category);
	
	public ApiResponse updateCategory(LocationCategory category);
	
	public ApiResponse findCategoryById(long categoryId);
	
	public ApiResponse deleteCategoryById(long categoryId);

	public ApiResponse queryLocations(String query);

}
