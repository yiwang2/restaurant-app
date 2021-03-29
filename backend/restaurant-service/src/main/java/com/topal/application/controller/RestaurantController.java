package com.topal.application.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topal.application.service.RestaurantInfoService;
import com.topal.om.restaurant.RestaurantInfo;
import com.topal.om.restaurant.dto.UpdateRestaurantDTO;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantInfoService restaurantService;
	
	@PostMapping("/restaurant")
	public RestaurantInfo addNewRestaurant(@Valid @RequestBody RestaurantInfo user) {
		return this.restaurantService.saveRestaurantInfo(user);
	}
	
	@PutMapping("/restaurant/{id}")
	public RestaurantInfo updateUserBuildingInfo(@Valid @RequestBody UpdateRestaurantDTO updateRestaurant, @NotBlank @PathVariable Integer id) {
		RestaurantInfo existingRestaurant = restaurantService.findRestaurantById(id);
		
		
		if (updateRestaurant.getDescription() != null) {
			existingRestaurant.setDescription(updateRestaurant.getDescription());
		}
		
		if (updateRestaurant.getOpeningHours() != null && updateRestaurant.getOpeningHours().size() > 0) {
			existingRestaurant.setOpeningHours(updateRestaurant.getOpeningHours());
		}
		
		return this.restaurantService.saveRestaurantInfo(existingRestaurant);
	}
	
	@DeleteMapping(value = "/restaurant/{id}")
	public void deleteUserInfo(@PathVariable Integer id) {
		this.restaurantService.deleteRestaurantById(id);
	}
}
