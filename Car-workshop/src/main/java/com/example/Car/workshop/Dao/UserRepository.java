package com.example.Car.workshop.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Car.workshop.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	// Optional: custom queries

	Optional<User> findByName(String name);

	Optional<User> findByNumber(String name);

}