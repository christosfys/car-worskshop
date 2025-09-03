package com.example.Car.workshop.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Car.workshop.Entities.Appoitment;

public interface AppoitmentRepository extends JpaRepository<Appoitment,Integer> {

}
