package com.topal.om.restaurant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor @AllArgsConstructor
public class RestaurantInfo {

	@Id
	@GeneratedValue(generator = "randomRestaurantId")
	@GenericGenerator(name = "randomRestaurantId", strategy = "com.topal.om.utils.RandomIntegerIdGenerator")
	private Integer id;
	@NotBlank(message = "The user id shall not be left as blank")
	private Integer ownerId;
	
	private String description;
	
	private List<String> openingHours = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

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
