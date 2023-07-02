package com.example.tomorrowland.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tomorrowland.entity.User;
import com.example.tomorrowland.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id, @RequestBody User user){
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable("id") Long id, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User record deleted successfully !", HttpStatus.OK);
	}

}
