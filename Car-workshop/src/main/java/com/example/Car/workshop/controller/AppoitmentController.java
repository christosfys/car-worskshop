package com.example.Car.workshop.controller;

import com.example.Car.workshop.Entities.Appoitment;
import com.example.Car.workshop.Service.AppoitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
