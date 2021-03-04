package com.babatunde.yctlocationintelligence.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babatunde.yctlocationintelligence.constants.ResponseConstants;
import com.babatunde.yctlocationintelligence.model.YctLocations;
import com.babatunde.yctlocationintelligence.model.YctSubLocations;
import com.babatunde.yctlocationintelligence.repository.LocationRepository;
import com.babatunde.yctlocationintelligence.repository.YctSubLocationsRepository;
import com.babatunde.yctlocationintelligence.response.ApiResponse;
import com.babatunde.yctlocationintelligence.service.YctSubLocationsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class YctSubLocationsServiceImpl implements YctSubLocationsService {

	@Autowired
	private YctSubLocationsRepository subLocationsRepo;

	@Autowired
	private LocationRepository locationRepo;

	@Override
	public ApiResponse addNewSubLocation(YctSubLocations subLocation) {
		log.info("Trying to add new location with requets: {}", subLocation);
		ApiResponse response = new ApiResponse();
		try {
			Optional<YctLocations> mainLocation = locationRepo.findById(subLocation.getLocation().get(0).getId());
			if (mainLocation.isPresent()) {
				String abbreviation = mainLocation.get().getAbbreviation() == null ? ""
						: " (" + mainLocation.get().getAbbreviation() + ")";
				subLocation.setName(subLocation.getName() + abbreviation);
				YctSubLocations addedSubLocations = subLocationsRepo.save(subLocation);
				if (addedSubLocations != null) {
					response.setCode(ResponseConstants.SUCCESS.getCode());
					response.setMessage("Successfully added new location");
					log.info("Successfully addded new sublocations");
				}
			} else {
				response.setCode(ResponseConstants.EMPTY_RESULT.getCode());
				response.setMessage("Successfully added new location");
			}

		} catch (Exception ex) {
			log.error("Exception occured while trying to add new sublocation with request: {} becasue: {}", subLocation,
					ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse updateSubLocation(YctSubLocations subLocation) {
		ApiResponse response = new ApiResponse();
		log.info("Trying to update ");
		try {
			YctSubLocations updatedSubLocations = subLocationsRepo.save(subLocation);
			if (updatedSubLocations != null) {
				response.setCode(ResponseConstants.SUCCESS.getCode());
				response.setMessage("Successfully updated the location");
			}
		} catch (Exception ex) {
			log.error("Exception occured while trying to add new sublocation with request: {} becasue: {}", subLocation,
					ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse findById(long id) {
		ApiResponse response = new ApiResponse();
		log.info("Trying to find sublocation by id: {}", id);
		try {
			Optional<YctSubLocations> location = subLocationsRepo.findById(id);
			if (location.isPresent()) {
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(location.get());
				log.info("Successfully found sublocation with id: {} as it returns: {}", location.get());
			} else {
				log.info("Sublocation with id: {} cannot be found", id);
				response.setResponse(ResponseConstants.NOT_FOUND);
			}
		} catch (Exception ex) {
			log.error("Exception occured while trying to find sublocation with id: {} because: {}", id, ex.getMessage(),
					ex);
		}
		return response;
	}

	@Override
	public ApiResponse deleteById(long id) {
		ApiResponse response = new ApiResponse();
		try {

		} catch (Exception ex) {

		}
		return response;
	}

	@Override
	public ApiResponse findAllSubLocations() {
		ApiResponse response = new ApiResponse();
		log.info("Trying to find all sublocations with request");
		try {
			List<YctSubLocations> allLocations = subLocationsRepo.findAll();
			if (!allLocations.isEmpty()) {
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(allLocations);
				log.info("Successfully found: {} sublocations", allLocations.size());
			} else {
				response.setResponse(ResponseConstants.EMPTY_RESULT);
				log.info("No result found");
			}
		} catch (Exception ex) {
			log.error("Exception occured while trying to fetch all sublocations because: {}", ex.getMessage(), ex);
		}
		return response;
	}

	@Override
	public ApiResponse findAllSubLocationsByName(String query) {
		ApiResponse response = new ApiResponse();
		log.info("Trying to find all sublocations with query: {}", query);
		try {

			List<YctSubLocations> allLocations = subLocationsRepo.findByNameLike(query);
			List<YctLocations> locations = locationRepo.findAllByNameLike(query);
			if (!allLocations.isEmpty()) {
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(allLocations);
				log.info("Successfully found: {} sublocations with query: {}", allLocations.size(), query);
				return response;
			} else if (!locations.isEmpty()) {
				log.info("Could not find the sublocations so returning the location details found instead: {}",
						locations);
				response.setResponse(ResponseConstants.SUCCESS);
				response.setData(Arrays.asList(new YctSubLocations(locations)));
				log.info("Successfully found: {} sublocations with query: {}", allLocations.size(), query);

			} else {
				response.setResponse(ResponseConstants.EMPTY_RESULT);
				log.info("No result found with query: {}", query);
			}
		} catch (Exception ex) {
			log.error("Exception occured while trying to fetch all sublocations with query: {} because: {}", query,
					ex.getMessage(), ex);
		}
		return response;
	}

}
