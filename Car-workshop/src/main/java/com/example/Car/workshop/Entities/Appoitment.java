package com.example.Car.workshop.Entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appoitment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	private Date date;
	private String description;
	private int cost;
	
	public Appoitment() {
		super();
	}
	public Appoitment(Date date, String description, int cost) {
		super();
		this.date = date;
		this.description = description;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
}
