package com.example.Car.workshop.controller;

import com.example.Car.workshop.Entities.Appoitment;
import com.example.Car.workshop.Entities.User;
import com.example.Car.workshop.Entities.Vehicle;
import com.example.Car.workshop.Service.AppoitmentService;
import com.example.Car.workshop.Service.VehicleService;
import com.example.Car.workshop.dto.AppoitmentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppoitmentController {

	@Autowired
	private AppoitmentService appoitmentService;
	@Autowired
	private VehicleService vehicleService;

	// CREATE
	@PostMapping
	public Appoitment create(@RequestBody Appoitment appoitment) {
		System.out.println(appoitment);

		return appoitmentService.create(appoitment);
	}

	// READ (all)
	@GetMapping
	public List<Appoitment> getAll() {
		return appoitmentService.findAll();
	}

	// READ (by id)
	@GetMapping("/{id}")
	public Appoitment getById(@PathVariable int id) {
		return appoitmentService.findById(id);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		appoitmentService.delete(id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Appoitment appoitment) {

	}

	@PostMapping("/vehicles/{id}")
	public void createforVehicle(@PathVariable int id, @RequestBody Appoitment appoitment) {

		Optional<Vehicle> optionalUser = vehicleService.getVehicleById(id);
		System.out.println(optionalUser.toString());
		if (optionalUser.isPresent()) {
			appoitment.setVehicle(optionalUser.get());

			appoitmentService.create(appoitment);
		} else {

			System.out.println("User not found with id: " + id);

		}
	}

	@GetMapping("/vehicles/{id}")
	public List<Appoitment> getAppoitmentsByVehicle(@PathVariable int id) {
		List<Appoitment> list_appoitments = appoitmentService.getByVehicleId(id);
		return list_appoitments;

	}

	@GetMapping("/date/{date}and{date1}")
	public List<Appoitment> getAppoitmentsByDate(@PathVariable String date, @PathVariable String date1) {
		Date start = Date.valueOf(date);
		Date end = Date.valueOf(date1);
		return appoitmentService.getBydate(start, end);
	}

	@GetMapping("/user/{id}")
	public List<Appoitment> getAppoitmentByUser(@PathVariable int id) {
		System.out.println("kane kati");
		return appoitmentService.getbyUserId(id);

	}

	@GetMapping("/appdto")
	public List<AppoitmentDto> getAppdDto() {
		List<Appoitment> find = appoitmentService.findAll();

		List<AppoitmentDto> dtos = find.stream().map(app -> {
			AppoitmentDto dto = new AppoitmentDto();
			dto.setId(app.getId());
			dto.setDescription(app.getDescription());
			dto.setDate(app.getDate());
			dto.setPlateNumber(app.getVehicle().getPlateNumber());

			return dto; // <-- important
		}).toList(); // <-- close the stream and collect to list

		return dtos;
	}

	@GetMapping("/date")
	public List<Appoitment> getAppBydate() {
		List<Appoitment> find = appoitmentService.getBydate();

		return find;
	}
}
