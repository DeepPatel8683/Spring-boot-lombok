package com.onerivet.dtoentity;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DtoUser {
	
	
	private int id;
	
	@NotEmpty
	@Size(min=2,max=20,message = "Name should be 20 charcter long")
	private String firstName;
	@NotEmpty
	@Size(min=2,max=20,message = "Name should be 20 charcter long")
	private String lastName;
	@NotEmpty
	@Size(min=2,max=20,message = "Name should be 20 charccter long")
	private String city;
	
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	@NotEmpty
	@Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,20}$")
	private String password;
	@NotEmpty
	@Pattern(regexp = "^[6-9]\\d{9}$")
	private String mobileNumber;
	

}
