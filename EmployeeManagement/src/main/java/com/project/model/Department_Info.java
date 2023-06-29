package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Department_Info {
	@Id
	private int department_id;
	@Column
	
	private String department_name;
	@Column
	private long total_employee;
	@Column
	private String depatment_head;
	
	@Column
	private String vertical;
	
	public Department_Info() {
	
	}

	public Department_Info(int department_id, String department_name, long total_employee, String depatment_head,
			String vertical) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.total_employee = total_employee;
		this.depatment_head = depatment_head;
		this.vertical = vertical;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public long getTotal_employee() {
		return total_employee;
	}

	public void setTotal_employee(long total_employee) {
		this.total_employee = total_employee;
	}

	public String getDepatment_head() {
		return depatment_head;
	}

	public void setDepatment_head(String depatment_head) {
		this.depatment_head = depatment_head;
	}

	public String getVertical() {
		return vertical;
	}

	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	
	
	
	

	
}
