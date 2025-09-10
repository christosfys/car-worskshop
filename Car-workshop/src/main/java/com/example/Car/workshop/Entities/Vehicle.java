package com.example.Car.workshop.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
	@Valid
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Max(value = 2025, message = "Year cannot be in the future") 
	private int year;
	
    @Column(name = "plate_number", nullable = false)
    @JsonProperty("plate_number") // allows JSON to use "plate_number"

    @Pattern(regexp = "^[A-Z]{3}-[0-9]{4}$",
    message = "The template must have the specific number for example AAA-1111")

    @NotNull(message="The licencse plate is required")
    private String plateNumber;

    private String model;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    
    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL)
	@JsonManagedReference
    private List<Appoitment> appoitments=new ArrayList<>();
    
    

    // Constructors
    public Vehicle() {}

    public Vehicle(int year, String plateNumber, String model) {
        this.year = year;
        this.plateNumber = plateNumber;
        this.model = model;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

	public List<Appoitment> getAppoitments() {
		return appoitments;
	}

	public void setAppoitments(List<Appoitment> appoitments) {
		this.appoitments = appoitments;
	}
}
