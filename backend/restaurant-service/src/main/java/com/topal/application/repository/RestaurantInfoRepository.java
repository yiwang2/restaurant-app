package com.topal.application.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.topal.om.restaurant.RestaurantInfo;

@Repository
public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Integer>{

}
