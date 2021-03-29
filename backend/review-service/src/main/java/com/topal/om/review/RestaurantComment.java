package com.topal.om.review;

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
@Table(name = "restaurant_comment") 
@NoArgsConstructor @AllArgsConstructor
public class RestaurantComment{
	

	@Id
	@GeneratedValue(generator = "randomCommentId")
	@GenericGenerator(name = "randomCommentId", strategy = "com.topal.om.utils.RandomStringIdGenerator")
	private String id;
	
	@NotBlank(message = "The restaurant id shall be left as blank")
	private String restaurantId;
	@NotBlank(message = "The user id shall not be left as blank")
	private Integer userId;
	@NotBlank(message = "The comment shall not be left as blank")
	private String comment;
	@NotBlank(message = "The stars shall not be left as blank")
	private Integer stars;
	
	private List<String> replies = new ArrayList<String>();
	
	private Long timeStamp;


	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public List<String> getReplies() {
		return replies;
	}
	public void setReplies(List<String> replies) {
		this.replies = replies;
	}
	
	
	
}
