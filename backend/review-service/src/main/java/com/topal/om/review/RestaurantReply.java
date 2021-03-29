package com.topal.om.review;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author yiwang
 *
 */
@Entity
@Table(name = "restaurant_reply") 
@NoArgsConstructor @AllArgsConstructor
public class RestaurantReply {

	@Id
	@GeneratedValue(generator = "randomReplyId")
	@GenericGenerator(name = "randomReplyId", strategy = "com.topal.om.utils.RandomStringIdGenerator")
	private String id;
	@NotBlank(message = "The user id shall not be left as blank")
	private Integer userId;
	@NotBlank(message = "The comment id shall not be left as blank")
	private String commentId;
	@NotBlank(message = "The reply content shall not be left as blank")
	private String reply;
	private Long timeStamp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
	
}
