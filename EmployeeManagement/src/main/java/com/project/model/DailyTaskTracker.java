package com.project.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class DailyTaskTracker {
	@Id

	private Long id;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH-mm-ss.SSSSSS")
	private Date loginTime;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH-mm-ss.SSSSSS")
	private Date logOutTime;
	@Column
	private String project_name;
	@Column
	private String client_name;

	@Column
	private double hours_worked;
	

	public String getEmployee_assigned_name() {
		return employee_assigned_name;
	}

	public void setEmployee_assigned_name(String employee_assigned_name) {
		this.employee_assigned_name = employee_assigned_name;
	}

	public double getHours_worked() {
		return hours_worked;
	}

//	@ManyToOne
//  @JoinColumn(name = "user_id")
//  private UserInfo user;
//  @ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="project_id")
//	private Project_Info project_Info;
	@Column
	private String employee_assigned_name;

	public DailyTaskTracker(String employee_assigned_name) {
		super();
		this.employee_assigned_name = employee_assigned_name;
	}

	public DailyTaskTracker(double hours_worked) {
		super();
		this.hours_worked = hours_worked;
	}
	public DailyTaskTracker(String project_name, String client_name) {
		super();
		this.project_name = project_name;
		this.client_name = client_name;
	}

	public DailyTaskTracker(Long id, UserInfo user, Date loginTime, Date logOutTime) {
		super();
		this.id = id;

		this.loginTime = loginTime;
		this.logOutTime = logOutTime;
	}

	public DailyTaskTracker() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date localDateTime) {
		this.loginTime = localDateTime;
	}

	public Date getLogOutTime() {
		return logOutTime;
	}

	public void setLogOutTime(Date logOutTime) {
		this.logOutTime = logOutTime;
	}



	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public void setHours_worked(double hours_worked) {
		this.hours_worked = hours_worked;
	}

	public double getHoursWorked() {
		if (loginTime != null && logOutTime != null) {
			long diff = logOutTime.getTime() - loginTime.getTime();
			return (double) diff / (60 * 60 * 1000);
		} else {
			return 0.0;
		}

	}

	
} 
