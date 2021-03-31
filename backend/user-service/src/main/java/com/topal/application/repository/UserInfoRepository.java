package com.topal.application.repository;

import org.springframework.stereotype.Repository;

import com.topal.application.om.UserInfo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@EntityScan("com.topal.application.om.*.*")
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

}
