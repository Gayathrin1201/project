package com.project.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.exception.ServiceException;
import com.project.model.UserInfo;
import com.project.repository.UserInfoRepository;



@Service
public class UserService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	 public String addUser(UserInfo userinfo)  //save User details
	   {
		 try {
		 
		   userinfo.setPassword(passwordEncoder.encode(userinfo.getPassword()));
		  userInfoRepository.save(userinfo);
		  return "user added to System";
		 
	   }
	 
	 catch (Exception e) {
		throw new ServiceException("603","Enter proper details");
	}
	   }

}
