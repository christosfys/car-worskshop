package com.example.Car.workshop.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Car.workshop.Entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	@Query("SELECT v FROM Vehicle v WHERE v.user.id = :userId")
	List<Vehicle> findByUserId(@Param("userId") int userId);

}
