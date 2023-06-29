package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.UserInfo;


public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>{

	UserInfo findByName(String username);

	UserInfo findById(String username);
//UserInfo findByName(String username);

//	void save(Optional<UserInfo> userinfo);
//
//	UserInfo findById(String username);

//	UserInfo findByEmail(String username);

}
