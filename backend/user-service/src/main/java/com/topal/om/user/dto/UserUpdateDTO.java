package com.topal.om.user.dto;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.topal.om.user.UserType;
import com.topal.om.validator.UserTypeSubset;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor @AllArgsConstructor
public class UserUpdateDTO {

	@JsonInclude(Include.NON_NULL)
	@Email(message = "Email should be valid")
	private String userEmail;
	
	@JsonInclude(Include.NON_NULL)
	@UserTypeSubset(anyOf = {UserType.ADMIN, UserType.OWNER, UserType.REGULAR})
	private UserType userType;
	
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}
