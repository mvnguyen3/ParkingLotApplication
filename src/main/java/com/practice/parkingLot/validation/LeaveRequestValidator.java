package com.practice.parkingLot.validation;

import org.springframework.stereotype.Service;

import com.practice.parkingLot.Exception.InvalidRequestException;


@Service
public class LeaveRequestValidator implements Validator{


	@Override
	public void validateCommand(String[] commandStringList) {		
		if(commandStringList.length == 3) {
			try {
				int hour = Integer.parseInt(commandStringList[2]);	
				if(hour > 0)
					return;			
			}catch(NumberFormatException e) {
				throw new InvalidRequestException("Leave request is invalid");
			}
			
		}
		throw new InvalidRequestException("Leave request is invalid");
	}
}
