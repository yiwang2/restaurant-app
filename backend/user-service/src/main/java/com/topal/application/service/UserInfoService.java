package com.topal.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.topal.application.exception.UserNotFoundException;
import com.topal.application.om.UserInfo;
import com.topal.application.repository.UserInfoRepository;

/**
 * @author yiwang
 *
 */
@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;


	@Value("${client.resourceServerUrl}")
	String resourceServerUrl;

	public UserInfo saveUser(UserInfo user) {
		return this.userInfoRepository.save(user);
	}

	/**
	 * @param userId
	 * @return the existing user or throw UserNotFoundException if not found
	 */
	public UserInfo findUserById(Long userId) {
		return this.userInfoRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	}

	public void deleteUserById(Long userId) {
		if (this.userInfoRepository.existsById(userId)) {
			this.userInfoRepository.deleteById(userId);
		} else {
			throw new UserNotFoundException(userId);
		}

	}

	public List<UserInfo> getAllUsers() {
		return this.userInfoRepository.findAll();
	}

}
