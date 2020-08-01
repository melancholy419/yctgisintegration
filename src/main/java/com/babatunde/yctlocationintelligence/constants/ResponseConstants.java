package com.babatunde.yctlocationintelligence.constants;

import lombok.Getter;

@Getter
public enum ResponseConstants {
	
	SUCCESS("00","Successful"),
	PROCESSOR_ERROR("99","An error occured while processing response. Please contact the adminstrator"),
	EMPTY_RESULT("11","Empty Resultset"),
	NOT_FOUND("50","The resource does not exist");
	
	private String code,message;
	
	ResponseConstants(String code,String message) {
		this.code=code;
		this.message=message;
	}

}
