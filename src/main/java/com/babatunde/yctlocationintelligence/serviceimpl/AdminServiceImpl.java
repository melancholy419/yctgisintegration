package com.babatunde.yctlocationintelligence.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babatunde.yctlocationintelligence.constants.ResponseConstants;
import com.babatunde.yctlocationintelligence.model.YctLocations;
import com.babatunde.yctlocationintelligence.repository.LocationRepository;
import com.babatunde.yctlocationintelligence.response.ApiResponse;
import com.babatunde.yctlocationintelligence.response.DashBoardDetails;
import com.babatunde.yctlocationintelligence.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Autowired
	private LocationRepository locationRepo;

	@Override
	public ApiResponse fetchDashBoardDetails() {
		ApiResponse response = new ApiResponse();
		log.info("Trying to fetch dashboard details");
		try {
			List<YctLocations> approvedLocations = locationRepo.findAllByIsApproved(true);
			List<YctLocations> pendingApproved = locationRepo.findAllByIsApproved(false);
			DashBoardDetails details = new DashBoardDetails(approvedLocations.size(), pendingApproved.size(), 0);
			log.info("Dashboard details returns: {}", details);
			response.setResponse(ResponseConstants.SUCCESS);
			response.setData(details);
		} catch (Exception ex) {
			log.error("Exception occured while trying to fetch dashboard details because: {}", ex.getMessage(), ex);
		}
		return response;
	}

}
