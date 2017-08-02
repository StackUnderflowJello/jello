package com.revature.dto;

public class UserDTO {

	private String email;
	
	public UserDTO(){
		
	}

	public UserDTO(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDTO [email=" + email + "]";
	}
	
}
