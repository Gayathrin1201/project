package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.project.model.Department_Info;

@Repository
public interface DepartmentRepository extends JpaRepository<Department_Info, String> {

	@Modifying
	@Query(value = "UPDATE department_info d SET total_employee = ( SELECT COUNT(*)FROM employee e WHERE e.designation = d.department_name)", nativeQuery = true)
	void updateNumberOfEmployees();

//	
}
