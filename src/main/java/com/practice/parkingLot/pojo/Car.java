package com.practice.parkingLot.pojo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Car {
	private String carRegistrationNumber;	
	private int carHourParked;
	private int carSlotNumber;
	
	
	public Car(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Car))
			return false;
		Car car = (Car) o;
		return this.carRegistrationNumber.equals(car.getCarRegistrationNumber());
	}
	
	@Override		
	public int hashCode() {
		int INDEX = 0;
		INDEX++;
		return this.carRegistrationNumber.length() + INDEX;
	}
	
}
