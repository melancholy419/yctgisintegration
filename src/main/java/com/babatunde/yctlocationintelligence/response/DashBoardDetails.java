package com.babatunde.yctlocationintelligence.response;

import com.babatunde.yctlocationintelligence.utilities.ConverterUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DashBoardDetails {

	private int totalLocations;
	private int totalPendingLocationRequests;
	private int totalUsers;
	
	
	public DashBoardDetails(int totalLocations,int totalPendingLocationRequests,int totalUsers){
		this.totalLocations = totalLocations;
		this.totalPendingLocationRequests=totalPendingLocationRequests;
		this.totalUsers = totalUsers;
	}
	
	@Override
	public String toString() {
		return ConverterUtils.toJson(this);
	}

}
