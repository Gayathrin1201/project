package com.example.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.shoppingcart.model.UserInfo;
import com.example.shoppingcart.model.ProductInfo;
import com.example.shoppingcart.repository.UserInfoRepository;
import com.example.shoppingcart.repository.ProductRepository;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRepository loginInfoRepository;
	
	@Autowired
	private ProductRepository productRepository; 
	
	@Autowired
private PasswordEncoder passwordEncoder;
//	
	public UserInfo addLonginDetails(UserInfo userInfo)
	{
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		return loginInfoRepository.save(userInfo);
	}
	
	public List<ProductInfo> showLonginDetails()
	{
		return productRepository.findAll();
	} 

}
