package com.practice.parkingLot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.parkingLot.utility.Utilities;
import com.practice.parkingLot.validation.ValidationResource;
import com.practice.parkingLot.validation.Validator;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	private ParkingCommandProcessor parkingCommandProcessor;

	@Autowired
	private Utilities utilities;

	@Autowired
	ValidationResource validationResource;

	@Override
	public boolean processFile(String filePath) {
		try {
			System.out.println("faoiwejfojawe;ofji");
			List<String> commandList = utilities.readFile(filePath);
			for (String commandString : commandList) {
				String[] commandStringList = commandString.split("\\s+"); // Split the string from space
				String command = commandStringList[0];
				String carRegistrationNumber;
				int slot_capacity, hour;
				Validator validator;
				switch (command) {
				case "create_parking_lot":
					validator = validationResource.getValidationType(command);
					validator.validateCommand(commandStringList);
					slot_capacity = Integer.parseInt(commandStringList[1]);
					parkingCommandProcessor.createParkingLot(slot_capacity);
					break;
				case "park":
					validator = validationResource.getValidationType(command);
					validator.validateCommand(commandStringList);
					carRegistrationNumber = commandStringList[1];
					parkingCommandProcessor.park(carRegistrationNumber);
					break;
				case "leave":
					validator = validationResource.getValidationType(command);
					validator.validateCommand(commandStringList);
					carRegistrationNumber = commandStringList[1];
					hour = Integer.parseInt(commandStringList[2]);
					parkingCommandProcessor.leave(carRegistrationNumber, hour);
					break;
				case "status":
					validator = validationResource.getValidationType(command);
					validator.validateCommand(commandStringList);
					parkingCommandProcessor.status();
					break;
				default:
					System.out.println(command + " is invalid");
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;

	}
}
