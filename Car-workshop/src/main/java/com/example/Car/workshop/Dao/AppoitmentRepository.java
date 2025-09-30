package com.example.Car.workshop.Dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Car.workshop.Entities.Appoitment;

public interface AppoitmentRepository extends JpaRepository<Appoitment, Integer> {

	public List<Appoitment> findBydateBetween(Date date, Date date1);

	@Query("SELECT COUNT(a) FROM Appoitment a WHERE a.date = :date")
	int getAppointmentPerDate(@Param("date") Date date);

	// public List<Appoitment> findByVehicleId(int id );
	public List<Appoitment> findByVehicleId(int id);

	public List<Appoitment> findAllByOrderByDate();

	Appoitment findByDateAndVehicleId(Date date, int vehicleId);

	@Query("SELECT a FROM Appoitment a " + "JOIN a.vehicle v " + "JOIN v.user u " + "WHERE u.id = :userId")
	List<Appoitment> findAppoitmentsByUserId(@Param("userId") int userId);

}
