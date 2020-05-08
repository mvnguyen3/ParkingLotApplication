package com.practice.parkingLot.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Utilities {
	public List<String> readFile(String filePath) throws IOException {		
		return Files.readAllLines(Paths.get(filePath));		
	}

	public boolean validateCommand(String[] commandStringList) {
		String command = commandStringList[0];	
		String carRegistrationNumber;
		int slot_capacity, hour;	
		try {
			switch(command) {
			case "create_parking_lot":
				slot_capacity = Integer.parseInt(commandStringList[1]);					
				break;
			case "park":
				carRegistrationNumber = commandStringList[1];				
				break;
			case "leave":
				carRegistrationNumber = commandStringList[1];
				hour = Integer.parseInt(commandStringList[2]);
				if(hour <= 0)
					return false;
				break;
			case "status":
				break;
			default: 
				return false;
			}	
		}catch(Exception e) {
			return false;
		}				
		return true;
	}
}
