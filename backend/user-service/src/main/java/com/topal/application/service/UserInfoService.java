package com.topal.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topal.application.exception.UserNotFoundException;
import com.topal.application.repository.UserInfoRepository;
import com.topal.om.user.UserInfo;

@Service
public class UserInfoService {

	@Autowired
    private UserInfoRepository userInfoRepository;
	
	public UserInfo saveUser (UserInfo user) {
		return this.userInfoRepository.save(user);
	}
	
	/**
	 * @param userId
	 * @return the existing user or throw UserNotFoundException if not found
	 */
	public UserInfo findUserById (Integer userId) {
		return this.userInfoRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
	}
	
	public void deleteUserById (Integer userId) {
		if (this.userInfoRepository.existsById(userId)) {
			this.userInfoRepository.deleteById(userId);
		} else {
			throw new UserNotFoundException(userId);
		}
		
	}
}
