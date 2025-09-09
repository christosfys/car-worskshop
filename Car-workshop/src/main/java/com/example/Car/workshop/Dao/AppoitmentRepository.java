package com.example.Car.workshop.Dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Car.workshop.Entities.Appoitment;

public interface AppoitmentRepository extends JpaRepository<Appoitment,Integer> {
	
	
	public List<Appoitment> findBydateBetween(Date date, Date date1);
	//public List<Appoitment> findByVehicleId(int id );
	public List<Appoitment> findByVehicleId(int id);
}
