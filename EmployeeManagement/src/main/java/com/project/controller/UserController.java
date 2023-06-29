package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.exception.ControllerException;
import com.project.exception.ServiceException;
import com.project.model.UserInfo;
import com.project.service.UserService;



@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(DetailsController.class);
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/new") //save User details
	public ResponseEntity<?> addNewUser(@RequestBody UserInfo userInfo)
	{try {
		logger.info("Add User Details");
		String user=userService.addUser(userInfo);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	catch (ServiceException e) {
		ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrormessage());
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	} catch (Exception e) {
		ControllerException ce = new ControllerException("604", "error");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	}
	
}
	
	
	

}