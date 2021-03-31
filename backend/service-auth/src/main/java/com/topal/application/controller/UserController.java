package com.topal.application.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.topal.dto.UserAuthenticationInfo;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public UserAuthenticationInfo getUser(Authentication authentication) {
		UserAuthenticationInfo authInfo = new UserAuthenticationInfo();
		authInfo.setUserName(authentication.getName());
		List<String> authoritiesString = authentication.getAuthorities().stream()
		  .map(authority -> authority.getAuthority()).collect(Collectors.toList());
		authInfo.setAuthorities(authoritiesString);
		return authInfo;
	}


}
