package com.topal.application.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.topal.om.review.RestaurantComment;

@Repository
public interface RestaurantCommentRepository extends JpaRepository<RestaurantComment, String>{

}
