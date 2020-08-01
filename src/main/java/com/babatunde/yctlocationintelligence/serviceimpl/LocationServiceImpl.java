package com.babatunde.yctlocationintelligence.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babatunde.yctlocationintelligence.constants.ResponseConstants;
import com.babatunde.yctlocationintelligence.model.YctLocations;
import com.babatunde.yctlocationintelligence.repository.LocationRepository;
import com.babatunde.yctlocationintelligence.response.ApiResponse;
import com.babatunde.yctlocationintelligence.service.LocationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepo;

	@Override
	public ApiResponse getAllLocations() {
		log.info("Trying to fetch all locations...");
		ApiResponse response = new ApiResponse();
		try {
			List<YctLocations> locations = locationRepo.findAll();
			if (locations.isEmpty()) {
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(locations);
				log.info("Successfully found locations");
			} else {
				log.info("Empty resultset returned while trying to get all locations");
				response.setResponse(ResponseConstants.EMPTY_RESULT);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to get all locations because: {}", ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse addNewLocation(YctLocations location) {
		log.info("Trying to add new locations with request: {}",location);
		ApiResponse response = new ApiResponse();
		try {
			YctLocations savedLocation = locationRepo.save(location);
			if (savedLocation != null) {
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(savedLocation);
				log.info("Successfully added location: {}",savedLocation);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to save location because: {}", ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse updateLocation(YctLocations location) {
		log.info("Trying to update locations with request: {}",location);
		ApiResponse response = new ApiResponse();
		try {
			YctLocations updatedLocation = locationRepo.save(location);
			if (updatedLocation != null) {
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(updatedLocation);
				log.info("Successfully updated location with request: {}",updatedLocation);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to update location because: {}", ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse deleteLocation(long locationId) {
		log.info("Trying to delete location with id: {}",locationId);
		ApiResponse response = new ApiResponse();
		try {
			Optional<YctLocations> location = locationRepo.findById(locationId);			
			if (location.isPresent()) {
				locationRepo.delete(location.get());
				response.setResponse(ResponseConstants.SUCCESS);
				log.info("Successfully deleted location with id: {}",locationId);
			} else {
				response.setResponse(ResponseConstants.NOT_FOUND);
				log.info("Unable to find location with id: {} because it does not exist",locationId);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to delete location with id: {} because: {}",locationId, ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse findLocation(long locationId) {
		log.info("Trying to find location with id: {}",locationId);
		ApiResponse response = new ApiResponse();
		try {
			Optional<YctLocations> location = locationRepo.findById(locationId);			
			if (location.isPresent()) {
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(location.get());
				log.info("Successfully found location with id: {}",locationId);
			} else {
				response.setResponse(ResponseConstants.NOT_FOUND);
				log.info("Unable to find location with id: {} because it does not exist",locationId);
			}
		} catch (Exception ex) {
			log.error("Error occured while trying to find location with id: {} because: {}",locationId, ex.getMessage(), ex);
		}
		return response;
	}

}
