package com.practice.parkingLot.unitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.practice.parkingLot.service.ParkingCommandProcessor;
import com.practice.parkingLot.service.ParkingServiceImpl;
import com.practice.parkingLot.utility.Utilities;
import com.practice.parkingLot.validation.CreateParkingRequestValidator;
import com.practice.parkingLot.validation.LeaveRequestValidator;
import com.practice.parkingLot.validation.ParkRequestValidator;
import com.practice.parkingLot.validation.StatusRequestValidator;
import com.practice.parkingLot.validation.ValidationResource;
import com.practice.parkingLot.validation.Validator;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotServiceTest {

	@InjectMocks
	ParkingServiceImpl parkingService;

	@Mock
	ParkingCommandProcessor parkingCommandProcessor;

	@Mock
	Utilities utilities;

	@Mock
	ValidationResource validationResource;
		
	@Mock
	Validator validator;
		
	@Mock
	CreateParkingRequestValidator createParkingRequestValidator;
	
	// Testing void method
	@Test
	public void parkingRequestValidation() {
		Mockito.when(validationResource.getValidationType("create_parking_lot")).thenReturn(createParkingRequestValidator);
		validator = validationResource.getValidationType("create_parking_lot");
		validator.validateCommand(new String[] {});
		Mockito.verify(validator, Mockito.times(1)).validateCommand(new String[] {});	
	}
	
	@Mock
	ParkRequestValidator parkRequestValidator;
	
	@Test
	public void parkRequestValidation() {
		Mockito.when(validationResource.getValidationType("park")).thenReturn(parkRequestValidator);
		validator = validationResource.getValidationType("park");
		validator.validateCommand(new String [] {});
		Mockito.verify(validator, Mockito.times(1)).validateCommand(new String[] {});
	}
	
	@Mock
	LeaveRequestValidator leaveRequestValidator;
	
	@Test
	public void leaveRequestValidation() {
		Mockito.when(validationResource.getValidationType("leave")).thenReturn(leaveRequestValidator);
		validator = validationResource.getValidationType("leave");
		validator.validateCommand(new String[] {});
		Mockito.verify(validator, Mockito.times(1)).validateCommand(new String[] {});
	}
	
	@Mock
	StatusRequestValidator statusRequestValidator;
	
	@Test
	public void statusRequestValidator() {
		Mockito.when(validationResource.getValidationType("status")).thenReturn(statusRequestValidator);
		validator = validationResource.getValidationType("status");
		validator.validateCommand(new String[] {});
		Mockito.verify(validator, Mockito.times(1)).validateCommand(new String[] {});
	}
	
	
}

















