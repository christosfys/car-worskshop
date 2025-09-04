package com.example.Car.workshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Car.workshop.Entities.User;
import com.example.Car.workshop.Service.UserService;

@RestController
@RequestMapping("/api/customers")
public class UserController {
	
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("")
	public List<User> getCustomer() {
		
		return userservice.getAllUsers();
		
		
	}
	
	@GetMapping("/{id}")
	public Optional<User> getCustomerbyId(@PathVariable int id) {
		
		return userservice.getUserById(id);
		
		
	}
	
	@PostMapping("")
	public void createCustomer(@RequestBody User user) {
		userservice.createUser(user);
		
		
	}
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable int id) {
		userservice.deleteUser(id);
		
		
	}
	
	
	
	
	

}
