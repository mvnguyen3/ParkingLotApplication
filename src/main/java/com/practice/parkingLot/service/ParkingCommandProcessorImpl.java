package com.practice.parkingLot.service;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.practice.parkingLot.pojo.Car;
import static com.practice.parkingLot.controller.ParkingLotMainController.*;

@Service
public class ParkingCommandProcessorImpl implements ParkingCommandProcessor {	
	
	private static Queue<Integer> nextNearestAvailableSlotQueue = new PriorityQueue<>((a, b) -> a-b); 
	private static Queue<String> statusMessages = new ArrayDeque<>();
	private static HashMap<Car, Integer> parkingLot;
	
	@Override
	public void status() {
		String parkingSummary = generateParkingSummary();
		statusMessages.offer(parkingSummary);
		while(!statusMessages.isEmpty()) {
			String status = statusMessages.poll();
			System.out.println(status);
		}
	}

	@Override
	public void park(String carRegistrationNumber) {		
		Car car = new Car(carRegistrationNumber);		
		// Check for available space in parking lot
		if(parkingLotIsFull()) {
			statusMessages.offer("Sorry, parking lot is full");
		}else {
			if(!parkingLot.containsKey(car)) {
				Integer nextNeareastAvailabilitySlot = nextNearestAvailableSlotQueue.poll();
				car.setCarSlotNumber(nextNeareastAvailabilitySlot);
				parkingLot.put(car, nextNeareastAvailabilitySlot);				
				statusMessages.offer("Allocated slot number: " + nextNeareastAvailabilitySlot);	
			}else {
				statusMessages.offer(carRegistrationNumber + " is currently in the parking lot");
			}						
		}				
	}


	private boolean parkingLotIsFull() {
		return nextNearestAvailableSlotQueue.isEmpty();	
	}
	
	private int calculateRatePerHour(int hour) {
		if(hour <= 2) {
			return 10;
		}else {
			return 10 + (10 * (hour - 2));
		}			
	}

	private String generateParkingSummary() {
		StringBuilder sb = new StringBuilder();
		sb.append("Slot No. Registration No.");			
		
		Comparator<Car> comparator = (a, b) -> a.getCarSlotNumber() - b.getCarSlotNumber();
		TreeMap<Car, Integer> sortedMap = new TreeMap<>(comparator);
		sortedMap.putAll(parkingLot);
		
		Iterator<Entry<Car, Integer>> iterator = sortedMap.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Car, Integer> entry = iterator.next();
			sb.append("\n"+entry.getValue()+ " " + entry.getKey().getCarRegistrationNumber());
		}			
		return sb.toString();
	}

	@Override
	public void createParkingLot(int slot_capacity) {
		if(parkingLot == null) {				
			parkingLot = new HashMap<>(slot_capacity);					
			for(int i=1; i<=slot_capacity; i++) {
				nextNearestAvailableSlotQueue.offer(i);
			}			
			statusMessages.offer("Created parking lot with "+slot_capacity+" slots.");
		}else {
			statusMessages.offer("Parking lot has already been created!!");
		}					
	}

	@Override
	public void leave(String carRegistrationNumber, int hour) {
		Car car = new Car(carRegistrationNumber);
		car.setCarHourParked(hour);
		
		Integer slotNumber = parkingLot.remove(car);
		if(slotNumber != null) {
			int priceCharge = calculateRatePerHour(car.getCarHourParked());
			String status = "Registration number "+ car.getCarRegistrationNumber() +" with Slot Number "+ slotNumber +" is free with Charge "+ priceCharge;
			statusMessages.offer(status);						 
			nextNearestAvailableSlotQueue.offer(slotNumber);	
		}else {
			statusMessages.offer("Registration number "+car.getCarRegistrationNumber()+" not found");	
		}		
	}	
}



















