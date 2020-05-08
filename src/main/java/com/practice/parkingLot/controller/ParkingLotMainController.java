package com.practice.parkingLot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.parkingLot.pojo.Car;
import com.practice.parkingLot.service.ParkingService;

@RestController
@RequestMapping("/api/v1")
public class ParkingLotMainController {
	
		
	@Autowired
	ParkingService parkingService;
	
	@GetMapping("/process-command")
	synchronized ResponseEntity<?> processCommand(@RequestParam("filePath") String filePath) {
		Map<String, Object> response = new HashMap<>();		
		parkingService.processFile(filePath);
		response.put("status", "File Process Successfully");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
						
								
	}
	
}





















