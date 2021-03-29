package com.topal.application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.topal.application.repository.UserRepository;
import com.topal.application.userdetails.CustomUserDetails;
import com.topal.application.userdetails.Role;
import com.topal.application.userdetails.User;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

	@Override
	public CustomUserDetails loadUserByUsername(String username)
	{
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Could not find Username");
		return new CustomUserDetails(user, getGrantedAuthorities(user.getRoles()));
	}

	private List<GrantedAuthority> getGrantedAuthorities(Collection<Role> roles)
	{
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}
}
