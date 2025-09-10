package com.example.Car.workshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Car.workshop.Dao.UserRepository;
import com.example.Car.workshop.Entities.User;
import com.example.Car.workshop.ExceptionHandlers.UserException;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepo;

    // Create a new user
    public User createUser(User user) {
    	Optional<User> user_exist=userrepo.findByNumber(user.getNumber());
    	if(user_exist.isEmpty()) {
    		userrepo.save(user);
    	}else {
    		throw new RuntimeException("The users phone is used by other user");
    	}
    	
    			
    			
    		return userrepo.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
    	
    	
    	
        return userrepo.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(int id) {
        return userrepo.findById(id);
    }

    // Update user
    public User updateUser(int id, User updatedUser) {
        Optional<User> existingUserOpt = userrepo.findById(id);
       
            // user not found, return null or throw exception
            return null;
        }
    

    // Delete user
    public boolean deleteUser(int id) {
        if (userrepo.existsById(id)) {
            userrepo.deleteById(id);
            return true;
        }
        return false;
    }
}
