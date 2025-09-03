package com.example.Car.workshop.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Car.workshop.Entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    // Optional: custom queries
	
	
	
}