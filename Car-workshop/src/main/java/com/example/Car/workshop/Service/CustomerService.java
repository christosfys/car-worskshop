package com.example.Car.workshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Car.workshop.Dao.CustomerRepository;
import com.example.Car.workshop.Entities.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    // Create a new customer
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    // Get customer by ID
    public Optional<Customer> getCustomerById(int id) {
        return customerRepo.findById(id);
    }

    // Update customer
    public Customer updateCustomer(int id, Customer updatedCustomer) {
        return customerRepo.findById(id)
                .map(existing -> {
                    existing.setName(updatedCustomer.getName());
                    existing.setNumber(updatedCustomer.getNumber());
                    existing.setVehicles(updatedCustomer.getVehicles());
                    return customerRepo.save(existing);
                })
                .orElse(null);
    }

    // Delete customer
    public boolean deleteCustomer(int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
