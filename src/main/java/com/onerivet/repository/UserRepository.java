package com.onerivet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onerivet.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> getUserByfirstName(String firstName);
	public List<User> getUserByLastName(String lastName);
	public List<User> getUserBycity(String city);
	
	
	@Query("SELECT u FROM User u WHERE u.email=:email")
	public List<User> getUserByEmail(@Param("email") String email);
//	public List<User> getByMobileNumber(long  mobileNumber);
	
}


