package com.example.Car.workshop.ExceptionHandlers;

public class PlateNumberException  extends RuntimeException{
	//private	String message="The Plate is used by other user";
	public PlateNumberException(String message) {
		super(message);
	//	this.message=message;
		
		
	}
	
	

}
