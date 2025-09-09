package com.example.Car.workshop.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Car.workshop.Dao.AppoitmentRepository;
import com.example.Car.workshop.Entities.Appoitment;

@Service
public class AppoitmentService {

    private final AppoitmentRepository repository;

    public AppoitmentService(AppoitmentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Appoitment create(Appoitment appoitment) {
    	
    	
        return repository.save(appoitment);
    }

    // READ (all)
    public List<Appoitment> findAll() {
        return repository.findAll();
    }

    // READ (by id)
    public Optional<Appoitment> findById(int id) {
        return repository.findById(id);
    }



    // DELETE
    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Appoitment> getBydate(Date date, Date date1) {
        return repository.findBydateBetween(date, date1);
    }
    
    public List<Appoitment> getByVehicleId(int id ){
    	return repository.findByVehicleId(id);
    }
}
