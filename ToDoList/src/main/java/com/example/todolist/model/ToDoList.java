package com.example.todolist.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@Builder
public class ToDoList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskID;
	@Column
	private String taskName;
	@Column
	private LocalDateTime currentDateTime;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH-mm-ss")
	private LocalDate dueTime;
	@Column
	private String taskDescription;	
	@Column
	private String status;
	@Column
	private LocalDate hitDate;
	
	public ToDoList() {
		super();
	}

	public ToDoList(int taskID, String taskName, LocalDateTime currentDateTime, LocalDate dueTime,
			String taskDescription, String status, LocalDate hitDate) {
		super();
		this.taskID = taskID;
		this.taskName = taskName;
		this.currentDateTime = currentDateTime;
		this.dueTime = dueTime;
		this.taskDescription = taskDescription;
		this.status = status;
		this.hitDate = hitDate;
	}

//	public int getTaskID() {
//		return taskID;
//	}
//
//	public void setTaskID(int taskID) {
//		this.taskID = taskID;
//	}
//
//	public String getTaskName() {
//		return taskName;
//	}
//
//	public void setTaskName(String taskName) {
//		this.taskName = taskName;
//	}
//
//	public LocalDateTime getCurrentDateTime() {
//		return currentDateTime;
//	}
//
//	public void setCurrentDateTime(LocalDateTime currentDateTime) {
//		this.currentDateTime = currentDateTime;
//	}
//
//	public LocalDate getDueTime() {
//		return dueTime;
//	}
//
//	public void setDueTime(LocalDate dueTime) {
//		this.dueTime = dueTime;
//	}
//
//	public String getTaskDescription() {
//		return taskDescription;
//	}
//
//	public void setTaskDescription(String taskDescription) {
//		this.taskDescription = taskDescription;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public LocalDate getHitDate() {
//		return hitDate;
//	}
//
//	public void setHitDate(LocalDate hitDate) {
//		this.hitDate = hitDate;
//	}
}
