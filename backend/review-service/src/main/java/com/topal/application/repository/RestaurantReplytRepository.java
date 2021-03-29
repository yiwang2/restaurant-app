package com.topal.application.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.topal.om.review.RestaurantReply;

@Repository
public interface RestaurantReplytRepository extends JpaRepository<RestaurantReply, String>{

}
