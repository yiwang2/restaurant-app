package com.topal.application.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topal.application.om.UserInfo;
import com.topal.application.om.dto.UserUpdateDTO;
import com.topal.application.service.AuthService;
import com.topal.application.service.UserInfoService;
import com.topal.dto.UserAuthenticationInfo;

@RestController
public class UserController {

	@Autowired
	private UserInfoService userService;
	
	@Autowired
	private AuthService authService;

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/user")
	public UserInfo addNewUser(@Valid @RequestBody UserInfo user) {
		return this.userService.saveUser(user);
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/user/{id}")
	public UserInfo updateUserBuildingInfo(@Valid @RequestBody UserUpdateDTO user, @NotBlank @PathVariable Long id) {
		UserInfo existingUser = userService.findUserById(id);
		if (user.getUserEmail() != null) {
			existingUser.setUserEmail(user.getUserEmail());
		}

		if (user.getUserType() != null) {
			existingUser.setUserType(user.getUserType());
		}

		return this.userService.saveUser(existingUser);
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping(value = "/user/{id}")
	public void deleteUserInfo(@PathVariable Long id) {
		this.userService.deleteUserById(id);
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/user")
	public List<UserInfo> getUsers() {
		return this.userService.getAllUsers();
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/user/current")
	public UserAuthenticationInfo getLoggedInUser() {
		return this.authService.getLoginPrincipal();
	}

}
