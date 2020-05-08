package com.practice.parkingLot.validation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.practice.parkingLot.Exception.InvalidRequestException;

@Service
@Qualifier(value = "parkRequestValidator")
public class ParkRequestValidator implements Validator{

	@Override
	public void validateCommand(String[] commandStringList) {
		if(commandStringList.length == 2) {			
			return;		
		}
		throw new InvalidRequestException("Park request is invalid");
	}

}
