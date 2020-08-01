package com.babatunde.yctlocationintelligence.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babatunde.yctlocationintelligence.constants.ResponseConstants;
import com.babatunde.yctlocationintelligence.model.LocationCategory;
import com.babatunde.yctlocationintelligence.repository.LocationCategoryRepository;
import com.babatunde.yctlocationintelligence.response.ApiResponse;
import com.babatunde.yctlocationintelligence.service.LocationCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LocationCategoryServiceImpl implements LocationCategoryService {

	@Autowired
	private LocationCategoryRepository categoryRepo;

	@Override
	public ApiResponse getAllLocationCategory() {
		log.info("Trying to get all location categories");
		ApiResponse response = new ApiResponse();
		try {
			List<LocationCategory> categories = categoryRepo.findAll();
			if (!categories.isEmpty()) {
				log.info("Successfully found {} location categories", categories.size());
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(categories);
			} else {
				response.setResponse(ResponseConstants.EMPTY_RESULT);
				log.info("No resultset found while trying to fetch all location categories");
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to get all location categories because: {}", ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse saveNewCategory(LocationCategory category) {
		log.info("Trying to add new location category with request: {} ", category);
		ApiResponse response = new ApiResponse();
		try {
			LocationCategory savedCategory = categoryRepo.save(category);
			if (savedCategory != null) {
				log.info("Successfully added new location category with request: {} ", category);
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(savedCategory);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to save new location category with request: {} because: {}",category,ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse updateCategory(LocationCategory category) {
		log.info("Trying to update location category with request: {} ", category);
		ApiResponse response = new ApiResponse();
		try {
			LocationCategory savedCategory = categoryRepo.save(category);
			if (savedCategory != null) {
				log.info("Successfully updated location category with request: {} ", category);
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(savedCategory);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to update location category with request: {} because: {}",category,ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse findCategoryById(long categoryId) {
		log.info("Trying to find location category with id: {} ", categoryId);
		ApiResponse response = new ApiResponse();
		try {
			Optional<LocationCategory> category = categoryRepo.findById(categoryId);
			if (category.isEmpty()) {
				log.info("Successfully found location category with id: {} ", categoryId);
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(category.get());
			}else {
				response.setResponse(ResponseConstants.NOT_FOUND);
				log.warn("The location category with id: {} does not exist",categoryId);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to find location category with id: {} because: {}",categoryId,ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse deleteCategoryById(long categoryId) {
		log.info("Trying to delete location category with id: {} ", categoryId);
		ApiResponse response = new ApiResponse();
		try {
			Optional<LocationCategory> category = categoryRepo.findById(categoryId);
			if (category.isEmpty()) {
				categoryRepo.delete(category.get());
				log.info("Successfully deleted location category with id: {} ", categoryId);
				response.setResponse(ResponseConstants.SUCCESS);
			}else {
				response.setResponse(ResponseConstants.NOT_FOUND);
				log.warn("The location category with id: {} does not exist",categoryId);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to delete location category with id: {} because: {}",categoryId,ex.getMessage(), ex);
		}
		return response;
	}

}
