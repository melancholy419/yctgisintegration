package com.babatunde.yctlocationintelligence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babatunde.yctlocationintelligence.response.ApiResponse;
import com.babatunde.yctlocationintelligence.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public AdminService adminService;

	@GetMapping("/dashboard-details")
	public ApiResponse getDashBoardDetails() {
		return adminService.fetchDashBoardDetails();
	}
	
	
	
	

}
