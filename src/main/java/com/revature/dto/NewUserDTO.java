package com.revature.dto;

public class NewUserDTO {
	
	private String regEmail;
	private String regPassword;
	
	public NewUserDTO() {}

	public String getRegEmail() {
		return regEmail;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}

	public String getRegPassword() {
		return regPassword;
	}

	public void setRegPassword(String regPassword) {
		this.regPassword = regPassword;
	}

	@Override
	public String toString() {
		return "NewUserDTO [regEmail=" + regEmail + ", regPassword=" + regPassword + "]";
	}
	

}
