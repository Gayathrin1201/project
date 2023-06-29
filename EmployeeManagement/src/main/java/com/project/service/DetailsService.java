package com.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.project.exception.ServiceException;
import com.project.model.Employee;
import com.project.repository.DepartmentRepository;
import com.project.repository.EmployeeRepository;


import jakarta.transaction.Transactional;

@Service
public class DetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public Employee saveDetails(@RequestBody Employee employee) // save Employee,Department and Project Details
	{
		try {
			return employeeRepository.save(employee);

		} catch (Exception e) {
			throw new ServiceException("601", "Enter proper details");
		}
	}

	@Transactional
	public void updateNumberOfEmployees() // update Number of Employees in Department Entity
	{
		departmentRepository.updateNumberOfEmployees();
	}

	public List<Employee> getAllDetails() // get all the Details
	{
		return employeeRepository.findAll();

	}

	public Employee getById(int id) // get details by employee Id
	{
		return employeeRepository.findById(id).orElse(null);
	}
}
