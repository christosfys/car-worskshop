package com.example.Car.workshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Car.workshop.Entities.User;
import com.example.Car.workshop.Service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/api/customers")
	public List<User> getCustomer() {
		
		return userservice.getAllUsers();
		
		
	}
	
	@GetMapping("/api/customers/{id}")
	public Optional<User> getCustomerbyId(@PathVariable int id) {
		
		return userservice.getUserById(id);
		
		
	}
	
	@PostMapping("/api/customers")
	public void createCustomer(@RequestBody User user) {
		userservice.createUser(user);
		
		
	}
	@DeleteMapping("/api/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		userservice.deleteUser(id);
		
		
	}
	
	
	
	
	

}
