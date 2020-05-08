package com.practice.parkingLot.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationResource {
	
	@Autowired
	Validator validator;
	
	@Autowired
	CreateParkingRequestValidator createParkingRequestValidator;
	
	@Autowired
	LeaveRequestValidator leaveRequestValidator;
	
	@Autowired
	ParkRequestValidator parkRequestValidator;
	
	@Autowired
	StatusRequestValidator statusRequestValidator;
		
	
	public Validator getValidationType(String requestType) {		
		switch(requestType) {
			case "create_parking_lot":			
				return createParkingRequestValidator;
			case "leave":
				return leaveRequestValidator;
			case "park":
				return parkRequestValidator;
			case "status":
				return statusRequestValidator;
		
		}
		return null;
	}
}
