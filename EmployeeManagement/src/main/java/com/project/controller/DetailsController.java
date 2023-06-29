package com.project.controller;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.exception.ControllerException;
import com.project.exception.ServiceException;
import com.project.model.Employee;

import com.project.service.DetailsService;


@RestController
public class DetailsController {
	Logger logger = LoggerFactory.getLogger(DetailsController.class);
	
	@Autowired
	private DetailsService detailsService;
	private int employeeid;

	public int getEmployeeid() {
		return employeeid;
	}

	@PostMapping("/admin") // save Employee,Department and Project Details
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> saveDetails(@RequestBody Employee employee) {
		try {
			logger.info("Add Employee,Department and Project Details");

			Employee savedEmployee = detailsService.saveDetails(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
		} catch (ServiceException e) {
			ControllerException ce = new ControllerException(e.getErrorcode(), e.getErrormessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("602", "error");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getdetail") // get all the Details
	public List<Employee> getAllDetails() {

		logger.info("Get all the Details");
		return detailsService.getAllDetails();
	}

	//@PreAuthorize("hasAuthority('ROLE_USER')") // This can be Accessed by User Only
	@GetMapping("/employeebyid/{id}") // get details by employee Id
	public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {

		logger.info("Get details by Employee id");
		Employee employee = detailsService.getById(id);
		if (employee == null) {
			logger.info("Employee Not Found");
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(employee);
		}
	}

	@PutMapping("/updateNumberOfEmployees") // update Number of Employees in Department Entity
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") // This can be accessed by admin only
	public void updateNumberOfEmployee() {

		logger.info("Update Number of Employee in Department table");
		detailsService.updateNumberOfEmployees();

	}

//	

}
