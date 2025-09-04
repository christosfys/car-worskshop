package com.example.Car.workshop.controller;

import com.example.Car.workshop.Entities.Appoitment;
import com.example.Car.workshop.Service.AppoitmentService;
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

    // CREATE
    @PostMapping
    public Appoitment create(@RequestBody Appoitment appoitment) {
        return appoitmentService.create(appoitment);
    }

    // READ (all)
    @GetMapping
    public List<Appoitment> getAll() {
        return appoitmentService.findAll();
    }

    // READ (by id)
    @GetMapping("/{id}")
    public Optional<Appoitment> getById(@PathVariable int id) {
        return appoitmentService.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        appoitmentService.delete(id);
    }
    
    @GetMapping("/date/{date}and{date1}")
    public List<Appoitment> getAppoitmentsByDate(
            @PathVariable String date,
            @PathVariable String date1) {
    	 Date start = Date.valueOf(date); // java.sql.Date.valueOf(String)
    	    Date end = Date.valueOf(date1);
        return appoitmentService.getBydate(start, end);
    }
}
