package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.onerivet.dtoentity.DtoUser;
import com.onerivet.entity.User;
import com.onerivet.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/welcome")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/add")
	public String addUser(@Valid @RequestBody DtoUser dtoUser) {
			
		
		return userService.addUser(dtoUser);
		
		
	}
	
	@GetMapping("/getall")
	public List<DtoUser> getAll() {

		return userService.getAll();

	}
	
	@GetMapping("/id/{id}")
	public DtoUser getUserById(@PathVariable int id) {

		return userService.getUserById(id);

	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteUserById(@PathVariable int id) {

		return userService.DeleteUserById(id);

	}
	
	@PutMapping("/update/{id}")
	public String updateUserById(@Valid @PathVariable Integer id, @RequestBody DtoUser dtoUser) {
		
		return userService.UpdateUserById(id,dtoUser);
		
	}

	@GetMapping("/user/{firstName}")
	public List<DtoUser> getUserByfirstName(@PathVariable String firstName ) {

		return userService.getUserByfirstName(firstName);

	}
	
	
	@GetMapping("lastName")
	public List<DtoUser> getUserBylastName(@RequestParam String lastName ) {

		return userService.getUserBylastName(lastName);

	}
	
	
	@GetMapping("city")
	public List<DtoUser> getUserByCity(@RequestParam String city ) {

		return userService.getUserByCity(city);

	}
	
	@GetMapping("email")
	public List<DtoUser> getUserByEmail(@RequestParam String email ) {

		return userService.getUserByEmail(email);

	}
}


