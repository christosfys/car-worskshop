package com.example.Car.workshop.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int year;
	@Column(name="plate_number")
	private String platenumber;
	private String model;
	
	
	public Vehicle() {
		super();
	}
	public Vehicle(int year, String plate_number, String model) {
		super();
		this.year = year;
		this.platenumber = plate_number;
		this.model = model;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPlate_number() {
		return platenumber;
	}
	public void setPlate_number(String plate_number) {
		this.platenumber = plate_number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	

}
