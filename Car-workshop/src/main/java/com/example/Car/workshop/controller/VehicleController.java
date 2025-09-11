package com.example.Car.workshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.example.Car.workshop.Entities.User;
import com.example.Car.workshop.Entities.Vehicle;
import com.example.Car.workshop.Service.UserService;
import com.example.Car.workshop.Service.VehicleService;

import jakarta.validation.Valid;

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
	public ResponseEntity<?> addVehicleByUser(@PathVariable int id, @RequestBody @Valid Vehicle vehicle,
			BindingResult bindingResult) {

		// 1️⃣ Handle validation errors
		if (bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).toList();
			return ResponseEntity.badRequest().body(errors);
		}

		// 2️⃣ Check if user exists
		Optional<User> optionalUser = userService.getUserById(id);
		if (optionalUser.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
		}

		vehicle.setUser(optionalUser.get());
		vehicleService.createVehicle(vehicle);

		return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
	}

	@GetMapping("/api/customers/{id}/vehicles")
	public ResponseEntity<?> getVehiclesByUser(@PathVariable int id) {
		List<Vehicle> list_vehicles = vehicleService.findVehicles(id);

		if (list_vehicles.isEmpty()) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "No vehicles found for this user.");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(list_vehicles, HttpStatus.OK);
	}

}
