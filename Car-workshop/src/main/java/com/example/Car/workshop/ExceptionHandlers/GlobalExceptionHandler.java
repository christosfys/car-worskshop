package com.example.Car.workshop.ExceptionHandlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Map<String, Object>> handleUserNotFound(UserException ex) {
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("status", 404);
		error.put("error", "Not Found");
		error.put("message", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NumberExistException.class)
	public ResponseEntity<Map<String, Object>> handleNumberException(NumberExistException ex) {
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("status", 403);
		error.put("error", "Already used");
		error.put("message", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}
	@ExceptionHandler(VehicleNotFoundException.class)
	public  ResponseEntity<Map<String,Object>> handleVehicleNotException(VehicleNotFoundException ex){
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("status", 404);
		error.put("error", "Vehicle Not Found");
		error.put("message", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}