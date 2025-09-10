package com.example.Car.workshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getCustomer() {
		
		List<User> list_users= userservice.getAllUsers();

        if (list_users.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No users found.");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(list_users, HttpStatus.OK);
		
	}
	
	
	
	
	@GetMapping("/{id}")
	public Optional<User> getCustomerbyId(@PathVariable int id) {
		
		Optional <User> isuser=userservice.getUserById(id);
		
		if(isuser.isEmpty()) {
			throw new RuntimeException("The user doesn't exist");
		}
		
		return isuser;
		
		
		
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
