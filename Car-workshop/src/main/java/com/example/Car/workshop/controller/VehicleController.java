package com.example.Car.workshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Car.workshop.Entities.Vehicle;
import com.example.Car.workshop.Service.VehicleService;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Get all vehicles
    @GetMapping("/api/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Get vehicle by ID
    @GetMapping("/api/vehicles/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable int id) {
        return vehicleService.getVehicleById(id);
    }

    // Create new vehicle
    @PostMapping("/api/vehicles")
    public void createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    // Delete vehicle by ID
    @DeleteMapping("/api/vehicles/{id}")
    public void deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
    }
}
