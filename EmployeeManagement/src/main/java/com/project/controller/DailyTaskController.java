package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.exception.ControllerException;
import com.project.exception.ServiceException;
import com.project.model.DailyTaskTracker;
import com.project.service.DailyTaskService;

@RestController
public class DailyTaskController {

	Logger logger = LoggerFactory.getLogger(DetailsController.class);
	@Autowired
	private DailyTaskService dailyTaskService;

	@PostMapping("/addDetails") //// save login and logout details and calculated hours work done
	public ResponseEntity<?> saveDetails(@RequestBody DailyTaskTracker dailyTaskTracker) {
		try {
			logger.info("Add Details");
			DailyTaskTracker dailyTask = dailyTaskService.addDetails(dailyTaskTracker);
			return ResponseEntity.status(HttpStatus.CREATED).body(dailyTask);
		} catch (ServiceException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrormessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("606", "error");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateProject") // update project name,client name,employee name
	public void updateProject() {
		logger.info("Update Project");
		dailyTaskService.updateProjectName();
		logger.info("Update Client Name");
		dailyTaskService.updateClientName();
		logger.info("Update Employee assigned name");
		dailyTaskService.updateEmloyeeName();
	}

}
