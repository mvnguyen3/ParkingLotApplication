package com.practice.parkingLot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.parkingLot.service.ParkingService;

@RestController
@RequestMapping("/api/v1")
public class ParkingLotMainController {

	@Autowired
	ParkingService parkingService;

	@GetMapping("/process-command")
	public synchronized ResponseEntity<Map<String, Object>> processCommand(@RequestParam("filePath") String filePath) {
		Map<String, Object> response = new HashMap<>();
		parkingService.processFile(filePath);
		System.out.println("I got called");
		response.put("status", "File Process Successfully");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

}
