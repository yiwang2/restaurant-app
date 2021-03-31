package com.topal.application.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.topal.dto.UserAuthenticationInfo;

@FeignClient(value="service-auth")
public interface AuthService {

	@RequestMapping(value = "/user/current",method = RequestMethod.GET)
    public UserAuthenticationInfo getLoginPrincipal();
}
