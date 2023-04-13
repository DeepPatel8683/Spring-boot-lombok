package com.onerivet.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.dtoentity.DtoUser;
import com.onerivet.entity.User;
import com.onerivet.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
    @Autowired
	private UserRepository userRepository;
	
	@Override
	public DtoUser userToDtoUser(User user) {
		
		DtoUser dtoUser = modelMapper.map(user, DtoUser.class);
		
//		DtoUser dtoUser = new DtoUser();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
//		dtoUser.setId(user.getId());
//		dtoUser.setFirstName(user.getFirstName());
//		dtoUser.setLastName(user.getLastName());
//		dtoUser.setCity(user.getCity());
//		dtoUser.setEmail(user.getEmail());
//		dtoUser.setPassword(user.getPassword());
//		dtoUser.setMobileNumber(user.getMobileNumber());
//		
		
		return dtoUser;
	}

	@Override
	public User dtoUserTOUser(DtoUser dtouser) {
	
		User user = modelMapper.map(dtouser, User.class);
//		user.setId(dtouser.getId());
//		user.setFirstName(dtouser.getFirstName());
//		user.setLastName(dtouser.getLastName());
//		user.setCity(dtouser.getCity());
//		user.setEmail(dtouser.getEmail());
//		user.setPassword(dtouser.getPassword());
//		user.setMobileNumber(dtouser.getMobileNumber());
//		
		return user;
	}

	@Override
	public String addUser(DtoUser user) {
		User user1 =dtoUserTOUser(user);
		userRepository.save(user1);
		
		
		return "User Added Successfully...";
		
		
	}
	
	
	@Override
	public DtoUser getUserById(int id) {
		
		return userRepository.findById(id).stream().map(userId->userToDtoUser(userId)).collect(Collectors.toList()).get(id);
	}

	@Override
	public String DeleteUserById(int id) {
		
		User u = userRepository.findById(id).get();
		if(u==null) {
			return "User Not Found.....";
		}
		
		userRepository.delete(u);
		return "Delete Succesfully...";
		
	}

	@Override
	public String UpdateUserById(Integer id, DtoUser dtoUser) {
		User record= userRepository.findById(id).get();
		
		if(record == null) {
			
			return "Not Found";
			
		}
		record.setFirstName(dtoUser.getFirstName());
		record.setLastName(dtoUser.getLastName());
		record.setPassword(dtoUser.getPassword());
		record.setCity(dtoUser.getCity());
		record.setEmail(dtoUser.getEmail());
		record.setMobileNumber(dtoUser.getMobileNumber());
		
		userRepository.save(record);
		return "Updated.....";
	}
	
	
	
	@Override
	public List<DtoUser> getAll() {
		return userRepository.findAll().stream().map(allUser -> userToDtoUser(allUser)).collect(Collectors.toList());
		
	}

	@Override
	public List<DtoUser> getUserByfirstName(String firstName) {
		
		return userRepository.getUserByfirstName(firstName).stream().map(fName -> userToDtoUser(fName)).collect(Collectors.toList());
	}

	@Override
	public List<DtoUser> getUserBylastName(String lastName) {
		
		return userRepository.getUserByLastName(lastName).stream().map(lName -> userToDtoUser(lName)).collect(Collectors.toList());
	}

	@Override
	public List<DtoUser> getUserByCity(String city) {
		
		return userRepository.getUserBycity(city).stream().map(userCity -> userToDtoUser(userCity)).collect(Collectors.toList());
	}

	@Override
	public List<DtoUser> getUserByEmail(String email) {
		
		return userRepository.getUserByEmail(email).stream().map(useremail -> userToDtoUser(useremail)).collect(Collectors.toList());
		
	}
	
}
