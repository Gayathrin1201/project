package com.example.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingcart.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	UserInfo findByuserName(String username);

}
