package com.practice.parkingLot.service;

public interface ParkingCommandProcessor {	

	// O(1)
	void park(String carRegistrationNumber);

	// TIME AND SPACE O(N)
	void status();

	// O(1)
	void createParkingLot(int slot_capacity);

	// O(1)
	void leave(String carRegistrationNumber, int hour);
}
