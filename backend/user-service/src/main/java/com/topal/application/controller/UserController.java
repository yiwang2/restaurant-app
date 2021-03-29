package com.topal.application.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topal.application.service.UserInfoService;
import com.topal.om.user.UserInfo;
import com.topal.om.user.dto.UserUpdateDTO;

@RestController
public class UserController {

	@Autowired
	private UserInfoService userService;
	
	@PostMapping("/user")
	public UserInfo addNewUser(@Valid @RequestBody UserInfo user) {
		return this.userService.saveUser(user);
	}
	
	@PutMapping("/user/{id}")
	public UserInfo updateUserBuildingInfo(@Valid @RequestBody UserUpdateDTO user, @NotBlank @PathVariable Integer id) {
		UserInfo existingUser = userService.findUserById(id);
		if (user.getUserEmail() != null) {
			existingUser.setUserEmail(user.getUserEmail());
		}
		
		if (user.getUserType() != null) {
			existingUser.setUserType(user.getUserType());
		}
		
		return this.userService.saveUser(existingUser);
	}
	
	@DeleteMapping(value = "/user/{id}")
	public void deleteUserInfo(@PathVariable Integer id) {
		this.userService.deleteUserById(id);
	}
}
