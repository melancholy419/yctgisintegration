package com.babatunde.yctlocationintelligence.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babatunde.yctlocationintelligence.constants.ResponseConstants;

@RestController
@RequestMapping("/public")
public class PublicController {
	
	@GetMapping("/response-codes")
	public List<String> getResponseCodes() {
		List<String> constants = new ArrayList<>();
		for(ResponseConstants c:ResponseConstants.values()) {
			constants.add(c+"("+c.getCode()+","+c.getMessage()+")");
		}
		
		return constants;
	}
	


}
