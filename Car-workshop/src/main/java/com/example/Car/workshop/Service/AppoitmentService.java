package com.example.Car.workshop.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Car.workshop.Dao.AppoitmentRepository;
import com.example.Car.workshop.Entities.Appoitment;
import com.example.Car.workshop.Entities.User;

@Service
public class AppoitmentService {
	@Autowired
	private AppoitmentRepository repository;

	@Autowired
	private UserService userservice;

	// CREATE
	public Appoitment create(Appoitment appoitment) {
		Appoitment app = repository.findByDateAndVehicleId(appoitment.getDate(), appoitment.getVehicle().getId());
		// to do max=5 int total=repository.getAppointmentPerDate(appoitment.getDate());

		if (repository.getAppointmentPerDate(appoitment.getDate()) == 5) {
			throw new RuntimeException("Max capacity");

		}
		if (app != null) {
			// System.out.println(app.toString());

			// throw new RuntimeException("kane kati");
			System.out.println(app.getDescription());
		}

		return repository.save(appoitment);
	}

	// READ (all)
	public List<Appoitment> findAll() {
		return repository.findAll();
	}

	// READ (by id)
	public Appoitment findById(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	// DELETE
	public void delete(int id) {
		repository.deleteById(id);
	}

	public List<Appoitment> getBydate(Date date, Date date1) {
		return repository.findBydateBetween(date, date1);
	}

	public List<Appoitment> getByVehicleId(int id) {
		return repository.findByVehicleId(id);
	}

	public List<Appoitment> getbyUserId(int id) {
		// TODO Auto-generated method stub
		User currentuser = userservice.getUserById(id);

		return repository.findAppoitmentsByUserId(id);
	}

	public List<Appoitment> getBydate() {
		return repository.findAllByOrderByDate();

	}
}
