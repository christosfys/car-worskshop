package com.example.Car.workshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Car.workshop.Dao.UserRepository;
import com.example.Car.workshop.Dao.VehicleRepository;
import com.example.Car.workshop.Entities.Vehicle;
@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehiclerepo;

    // Create a new user
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehiclerepo.save(vehicle);
    }

    // Get all Vehicles
    public List<Vehicle> getAllVehicles() {
        return vehiclerepo.findAll();
    }

    // Get Vehicle by ID
    public Optional<Vehicle> getVehicleById(int id) {
        return vehiclerepo.findById(id);
    }

    // Update Vehicle
    public Vehicle updateVehicle(int id, Vehicle updateVehicle) {
        Optional<Vehicle> existingvehiclerepoOpt = vehiclerepo.findById(id);
       
          
            return null;
        }
    

    // Delete vehicle
    public boolean deleteVehicle(int id) {
        if (vehiclerepo.existsById(id)) {
            vehiclerepo.deleteById(id);
            return true;
        }
        return false;
    }

	public void addforuser(int id) {
		// TODO Auto-generated method stub
		
	}
}
