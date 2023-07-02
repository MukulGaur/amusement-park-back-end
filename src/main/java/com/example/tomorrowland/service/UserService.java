package com.example.tomorrowland.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tomorrowland.entity.User;
import com.example.tomorrowland.exception.UserNotFoundException;
import com.example.tomorrowland.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	public User updateUser(User user, Long id) {
		User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		
		existingUser.setDateOfBirth(user.getDateOfBirth());
		existingUser.setEmail(user.getEmail());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setPassword(user.getPassword());
		existingUser.setUsername(user.getUsername());
		
		userRepository.save(existingUser);
		
		return existingUser;
	}
	
	public void deleteUser(Long id) {
		userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		userRepository.deleteById(id);
	}

}
