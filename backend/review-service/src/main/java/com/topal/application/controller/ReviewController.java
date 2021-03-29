package com.topal.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.topal.application.service.RestaurantCommentService;
import com.topal.application.service.RestaurantReplyService;
import com.topal.om.review.RestaurantComment;
import com.topal.om.review.RestaurantReply;
import com.topal.om.review.dto.RestaurantCommentUpdateDTO;
import com.topal.om.review.dto.RestaurantReplyUpdateDTO;

@RestController
public class ReviewController {

	@Autowired
	private RestaurantCommentService commentService;
	@Autowired
	private RestaurantReplyService replyService;
	
	
	@PostMapping("/comment")
	public void addNewComment(@Valid @RequestBody RestaurantComment comment) {
		this.commentService.saveRestaurantComment(comment);
	}
	
	@PostMapping("/reply")
	public void addNewReply(@Valid @RequestBody RestaurantReply reply) {
		RestaurantComment comment = commentService.findRestaurantCommentById(reply.getCommentId());
		List<String> replies = comment.getReplies();
		if (replies == null) {
			replies = new ArrayList<String>();
		}
		replies.add(reply.getId());
		comment.setReplies(replies);
		commentService.saveRestaurantComment(comment);
		this.replyService.saveRestaurantReply(reply);
	}
	
	@PutMapping("/comment/{id}")
	public RestaurantComment updateRestaurantComment(@Valid @RequestBody RestaurantCommentUpdateDTO updateComment, 
			@NotBlank @PathVariable String id) {
		RestaurantComment existingComment = commentService.findRestaurantCommentById(id);
		if (updateComment.getComment() != null) {
			existingComment.setComment(updateComment.getComment());
		}
		
		if (updateComment.getStars() != null) {
			updateComment.setStars(updateComment.getStars());
		}
		
		return this.commentService.saveRestaurantComment(existingComment);
	}
	
	@PutMapping("/reply/{id}")
	public RestaurantReply updateRestaurantReply(@Valid @RequestBody RestaurantReplyUpdateDTO updateReply, 
			@NotBlank @PathVariable String id) {
		RestaurantReply existingReply = replyService.findRestaurantReplyById(id);
		if (updateReply.getReply() != null) {
			existingReply.setReply(updateReply.getReply());
			
		} 
		
		return this.replyService.saveRestaurantReply(existingReply);
	}
	
	@DeleteMapping(value = "/comment/{id}")
	public void deleteComment(@PathVariable String id) {
		this.commentService.deleteRestaurantCommentById(id);
	}
	
	@DeleteMapping(value = "/reply/{id}")
	public void deleteReply(@PathVariable String id) {
		this.replyService.deleteRestaurantReplyById(id);
	}
}
