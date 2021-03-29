package com.topal.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topal.application.exception.RestaurantCommentNotFoundException;
import com.topal.application.repository.RestaurantCommentRepository;
import com.topal.om.review.RestaurantComment;


@Service
public class RestaurantCommentService {
	
	@Autowired
	private RestaurantCommentRepository restaurantCommentRepository;
	
	public RestaurantComment saveRestaurantComment (RestaurantComment comment) {
		return this.restaurantCommentRepository.save(comment);
	}
	

	public RestaurantComment findRestaurantCommentById (String id) {
		return this.restaurantCommentRepository.findById(id)
				.orElseThrow(() -> new RestaurantCommentNotFoundException(id));
	}
	
	public void deleteRestaurantCommentById (String id) {
		if (this.restaurantCommentRepository.existsById(id)) {
			this.restaurantCommentRepository.deleteById(id);
		} else {
			throw new RestaurantCommentNotFoundException(id);
		}
		
	}

}
