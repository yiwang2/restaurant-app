package com.topal.om.review.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
public class RestaurantCommentUpdateDTO {

	@JsonInclude(Include.NON_NULL)
	@NotBlank(message = "The comment shall not be left as blank")
	private String comment;
	
	@JsonInclude(Include.NON_NULL)
	@NotBlank(message = "The stars shall not be left as blank")
	private Integer stars;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}
}
