package com.babatunde.yctlocationintelligence.response;

import com.babatunde.yctlocationintelligence.constants.ResponseConstants;

import lombok.Data;

@Data
public class ApiResponse {
	
	private String code;
	
	private String message;
	
	private Object data;
	
	public ApiResponse() {
		this.code=ResponseConstants.PROCESSOR_ERROR.getCode();
		this.message=ResponseConstants.PROCESSOR_ERROR.getMessage();
	}
	
	public void setResponse(ResponseConstants constant) {
		this.code=constant.getCode();
		this.message=constant.getMessage();
	}

}
