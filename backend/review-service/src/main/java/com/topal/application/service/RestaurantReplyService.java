package com.topal.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topal.application.exception.RestaurantReplyNotFoundException;
import com.topal.application.repository.RestaurantReplytRepository;
import com.topal.om.review.RestaurantReply;

@Service
public class RestaurantReplyService {

	@Autowired
	private RestaurantReplytRepository restaurantReplytRepository;
	
	public RestaurantReply saveRestaurantReply (RestaurantReply reply) {
		return this.restaurantReplytRepository.save(reply);
	}
	

	public RestaurantReply findRestaurantReplyById (String id) {
		return this.restaurantReplytRepository.findById(id)
				.orElseThrow(() -> new RestaurantReplyNotFoundException(id));
	}
	
	public void deleteRestaurantReplyById (String id) {
		if (this.restaurantReplytRepository.existsById(id)) {
			this.restaurantReplytRepository.deleteById(id);
		} else {
			throw new RestaurantReplyNotFoundException(id);
		}
		
	}
}
