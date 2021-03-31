package com.topal.dto;

import java.io.Serializable;
import java.util.List;

public class UserAuthenticationInfo implements Serializable{
	private static final long serialVersionUID = -1681391176386972981L;
	
	private List<String> authorities;
	private String userName;
	
	public UserAuthenticationInfo () {
		
	}
	
	public UserAuthenticationInfo (String userName, List<String> authorities) {
		this.userName = userName;
		this.authorities = authorities;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
