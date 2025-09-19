package com.example.Car.workshop.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Car.workshop.Dao.UserRepository;
import com.example.Car.workshop.Entities.User;
import com.example.Car.workshop.ExceptionHandlers.DoubleWriteException;
import com.example.Car.workshop.ExceptionHandlers.NumberExistException;
import com.example.Car.workshop.ExceptionHandlers.UserException;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;

	// Create a new user
	public User createUser(User user) {
		Optional<User> user_exist = userrepo.findByNameAndNumber(user.getName(),user.getNumber());
		
		
		if (user_exist.isEmpty()) {
			userrepo.save(user);
			return userrepo.save(user);
		} else {
			throw new DoubleWriteException("The users phone is used by other user");
		}

	}


	public List<User> getAllUsers() {

		return userrepo.findAll();
	}


	public User getUserById(int id) {
		return userrepo.findById(id)
		        .orElseThrow(() -> new UserException("User with ID " + id + " does not exist"));

	}

	// Update user
	public User updateUser(int id, User updatedUser) {
		Optional<User> existingUserOpt = userrepo.findById(id);
		if (existingUserOpt.isEmpty()) {
			throw new UserException("The user with this id doens exist");

		} else {
			updatedUser.setId(existingUserOpt.get().getId());
			userrepo.save(updatedUser);
			return updatedUser;
		}

	}

	// Delete user
	public boolean deleteUser(int id) {
		if (!userrepo.existsById(id)) {
			throw new UserException("The user with this id doens exist");

		} else {
			userrepo.deleteById(id);
			return true;
		}
	
	}
}
