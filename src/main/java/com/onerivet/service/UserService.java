package com.onerivet.service;

import java.util.List;

import com.onerivet.dtoentity.DtoUser;
import com.onerivet.entity.User;

public interface UserService {
	
	public DtoUser userToDtoUser(User user);
	public User dtoUserTOUser(DtoUser user);
	
	public String addUser(DtoUser user);
	
	
	public DtoUser getUserById(int id);
	public String DeleteUserById(int id);
	public String UpdateUserById(Integer id, DtoUser dtoUser);
	public List<DtoUser> getUserByfirstName(String firstName);
	public List<DtoUser> getUserBylastName(String lastName);
	public List<DtoUser> getUserByCity(String city);
	
	
	public List<DtoUser> getUserByEmail(String email);
	public List<DtoUser> getAll();
	
	
	

	
	
	

}
