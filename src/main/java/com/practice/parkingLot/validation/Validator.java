package com.practice.parkingLot.validation;

import com.practice.parkingLot.Exception.InvalidRequestException;

public interface Validator {	
	void validateCommand(String[] commandStringList) throws InvalidRequestException;
}
