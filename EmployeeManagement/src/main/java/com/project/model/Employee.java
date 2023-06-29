package com.project.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue
	private int employee_id;
	@Column
	private String employee_name;
	@Column
	private float salary;
	@Column
	private String designation;
	@Column
	private String address;
	@Column
	private String blood_group;
	@Column
	private Long contact_number;

	@OneToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)

	@JoinColumn(name = "department_id")
	private Department_Info department_Info;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Employee_assigned_name", referencedColumnName = "employee_name")

	private List<Project_Info> projects;

	public Employee() {

	}

	public Employee(int employee_id, String employee_name, float salary, String designation, String address,
			String blood_group) {

		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.salary = salary;
		this.designation = designation;
		this.address = address;
		this.blood_group = blood_group;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public Long getContact_number() {
		return contact_number;
	}

	public void setContact_number(Long contact_number) {
		this.contact_number = contact_number;
	}

	public Employee(Department_Info department_Info) {
		super();
		this.department_Info = department_Info;
	}

	public Department_Info getDepartment_Info() {
		return department_Info;
	}

	public void setDepartment_Info(Department_Info department_Info) {
		this.department_Info = department_Info;
	}

	public Employee(List<Project_Info> projects) {
		super();
		this.projects = projects;
	}

	public List<Project_Info> getProjects() {
		return projects;
	}

	public void setProjects(List<Project_Info> projects) {
		this.projects = projects;
	}

}
