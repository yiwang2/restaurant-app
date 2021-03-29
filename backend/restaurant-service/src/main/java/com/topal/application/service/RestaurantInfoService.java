package com.topal.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topal.application.exception.RestaturantNotFoundException;
import com.topal.application.repository.RestaurantInfoRepository;
import com.topal.om.restaurant.RestaurantInfo;

@Service
public class RestaurantInfoService {

	@Autowired
	RestaurantInfoRepository restaurantInfoRepository;
	
	public RestaurantInfo saveRestaurantInfo (RestaurantInfo info) {
		return this.restaurantInfoRepository.save(info);
	}
	
	public RestaurantInfo findRestaurantById (Integer id) {
		return this.restaurantInfoRepository.findById(id)
				.orElseThrow(() -> new RestaturantNotFoundException(id));
	}
	
	public void deleteRestaurantById (Integer id) {
		this.restaurantInfoRepository.deleteById(id);
	}
}
