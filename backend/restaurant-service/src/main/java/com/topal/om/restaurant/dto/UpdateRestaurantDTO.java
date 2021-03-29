package com.topal.om.restaurant.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
public class UpdateRestaurantDTO {

	@JsonInclude(Include.NON_NULL)
	private String description;
	@JsonInclude(Include.NON_EMPTY)
	private List<String> openingHours = new ArrayList<>();
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(List<String> openingHours) {
		this.openingHours = openingHours;
	}
	
	
}
