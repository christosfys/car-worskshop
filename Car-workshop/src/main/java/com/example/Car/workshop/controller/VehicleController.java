package com.example.Car.workshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Car.workshop.Entities.User;
import com.example.Car.workshop.Entities.Vehicle;
import com.example.Car.workshop.Service.UserService;
import com.example.Car.workshop.Service.VehicleService;

@RestController
public class VehicleController {


    private final UserService userService;
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(UserService userService, VehicleService vehicleService) {
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

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
    
    
    @PostMapping("/api/customers/{id}/vehicles")
    public void insertvehicleforuser(@PathVariable int id,@RequestBody Vehicle vehicle) {
    	
    	
    	Optional<User> optionalUser = userService.getUserById(id);
    	System.out.println(optionalUser.toString());
    	if (optionalUser.isPresent()) {
    	    vehicle.setUser(optionalUser.get());
    	    vehicleService.createVehicle(vehicle);
    	} else {
    	 
    	    System.out.println("User not found with id: " + id);
    	
    	}    	
    }
    @GetMapping("/api/customers/{id}/vehicles")
    public List<Vehicle> getVehiclesByUser(@PathVariable int id) {
		List<Vehicle> list_vehicles=vehicleService.findVehicles(id);
		return list_vehicles;
    	
    }
}
