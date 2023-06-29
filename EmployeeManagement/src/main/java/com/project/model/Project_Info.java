package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Project_Info {
	
	
@Id	

private int project_id;
@Column
private String project_name;
@Column
private String project_duration;
@Column
private String client_name;
@Column
private String project_manager;

public Project_Info() {
	super();
}

public Project_Info(String project_name, String project_duration, String client_name, String project_manager) {
	super();
	this.project_name = project_name;
	this.project_duration = project_duration;
	this.client_name = client_name;
	this.project_manager = project_manager;
}

public int getProject_id() {
	return project_id;
}

public void setProject_id(int project_id) {
	this.project_id = project_id;
}

public String getProject_name() {
	return project_name;
}

public void setProject_name(String project_name) {
	this.project_name = project_name;
}

public String getProject_duration() {
	return project_duration;
}

public void setProject_duration(String project_duration) {
	this.project_duration = project_duration;
}

public String getClient_name() {
	return client_name;
}

public void setClient_name(String client_name) {
	this.client_name = client_name;
}

public String getProject_manager() {
	return project_manager;
}

public void setProject_manager(String project_manager) {
	this.project_manager = project_manager;
}


}



