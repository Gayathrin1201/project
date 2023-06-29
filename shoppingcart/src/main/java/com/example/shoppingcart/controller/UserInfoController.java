package com.example.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.model.UserInfo;
import com.example.shoppingcart.model.ProductInfo;
import com.example.shoppingcart.service.UserInfoService;

@RestController
public class UserInfoController {
	@Autowired
	UserInfoService loginInfoService;
	@PostMapping("/addUser")
	public UserInfo addUser(@RequestBody UserInfo userInfo)
	{
		return loginInfoService.addLonginDetails(userInfo);
	}
	
	@GetMapping("/showProduct")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<ProductInfo> getProducts()
	{
			return loginInfoService.showLonginDetails();
	}
	
	
}
