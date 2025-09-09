package com.example.Car.workshop.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Car.workshop.Entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Optional: custom queries
	
	
	
}