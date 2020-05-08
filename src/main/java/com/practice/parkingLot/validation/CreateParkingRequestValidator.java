package com.practice.parkingLot.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.practice.parkingLot.Exception.InvalidRequestException;

@Primary
@Service
public class CreateParkingRequestValidator implements Validator {


	@Override
	public void validateCommand(String[] commandStringList) {
		if(commandStringList.length == 2) {
			try {
				int slots = Integer.parseInt(commandStringList[1]);
				if(slots > 0)
					return;	
			}catch(NumberFormatException e) {
				throw new InvalidRequestException(e.getMessage());
			}			
		}								
		throw new InvalidRequestException("Create request is invalid");
	}
}
