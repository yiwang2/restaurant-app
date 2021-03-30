package com.topal.om.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.topal.om.validator.UserTypeSubset;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user") 
@NoArgsConstructor @AllArgsConstructor
public class UserInfo {

	@Id
	@GeneratedValue(generator = "randomUserId")
	@GenericGenerator(name = "randomUserId", strategy = "com.topal.om.utils.RandomIntegerIdGenerator")
	@JsonInclude(Include.NON_NULL)
	private Integer id;
	@NotBlank (message = "The user name shall be left as blank")
	private String userName;
	@NotBlank (message = "The user E-mail address shall be left as blank")
	@Email(message = "Email should be valid")
	private String userEmail;
	@UserTypeSubset(anyOf = {UserType.ADMIN, UserType.OWNER, UserType.REGULAR})
	private UserType userType;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserProfile userProfile;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
	
}
