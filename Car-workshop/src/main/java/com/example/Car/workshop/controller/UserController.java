package com.example.Car.workshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Car.workshop.Entities.Appoitment;
import com.example.Car.workshop.Entities.User;
import com.example.Car.workshop.ExceptionHandlers.UserException;
import com.example.Car.workshop.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userservice;

	
	@GetMapping("")
	public ResponseEntity<?> getCustomer() {

		List<User> list_users = userservice.getAllUsers();

		if (list_users.isEmpty()) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "No users found.");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(list_users, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public User getCustomerbyId(@PathVariable int id) {

	
		return  userservice.getUserById(id);

	}

	@PostMapping("")
	public ResponseEntity<?> createCustomer(@RequestBody @Valid User user, BindingResult bindingresult) {

		if (bindingresult.hasErrors()) {
			List<String> errors = bindingresult.getAllErrors().stream().map(ObjectError::getDefaultMessage).toList();
			return ResponseEntity.badRequest().body(errors);

		} else {

			userservice.createUser(user);
			return ResponseEntity.ok("The user has created");

		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {

		if (userservice.deleteUser(id)) {
			return ResponseEntity.ok("THe user with id:" + id + "has deleted successfully");
		} else {
			return ResponseEntity.badRequest().body(null);

		}

	}

	@PutMapping("/{id}")
	public void updateUser(@PathVariable int id, @RequestBody User user) {
		userservice.updateUser(id, user);
	}
	
	@GetMapping("/{id}/appoitment")
	public List<Appoitment> getappoitmentsperUser(@PathVariable int id){
		return null;
		
	}

	
	
}
