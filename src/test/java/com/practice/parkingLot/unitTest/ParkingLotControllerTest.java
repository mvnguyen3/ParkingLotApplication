package com.practice.parkingLot.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.practice.parkingLot.controller.ParkingLotMainController;
import com.practice.parkingLot.service.ParkingServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotControllerTest {
	
	@Mock// Mock an object which doesn't have any dependency 
	ParkingLotMainController parkingLotMainController;
	
//	@Mock
//	ParkingServiceImpl parkingService;
	
	@Test
	public void testProcessCommand() {
		Map<String, Object> response = new HashMap<>();
		response.put("status", "OK");
		String filePath = "any path";
		//Mockito.when(parkingService.processFile(filePath)).thenReturn(false);
		Mockito.when(parkingLotMainController.processCommand(filePath)).thenReturn(new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK));
		ResponseEntity<Map<String, Object>> responseEntity = parkingLotMainController.processCommand("any path");
		assertEquals("OK", responseEntity.getStatusCode().name());
		
		
	}
	
}
