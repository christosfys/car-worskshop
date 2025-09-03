package com.example.Car.workshop.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Car.workshop.Entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	public Vehicle findByplatenumber(String plate);


}
