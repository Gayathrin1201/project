package com.example.todolist.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.todolist.model.ToDoList;
import com.example.todolist.repository.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;

	public ToDoList addList(ToDoList toDoList) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		toDoList.setCurrentDateTime(currentDateTime);
		LocalDate date = LocalDate.now();
		toDoList.setHitDate(date);
		return toDoRepository.save(toDoList);
	}

	public List<ToDoList> getAllList() {
		return toDoRepository.findAll();
	}

	public ToDoList getListById(int id) {
		return toDoRepository.findByTaskID(id);
	}

	public List<ToDoList> getListByDate() {
		LocalDate startOfDay = LocalDate.now();
		LocalDate endOfDay = LocalDate.now();
		return toDoRepository.findByHitDateBetween(startOfDay, endOfDay);
	}

	public ToDoList updateList(ToDoList toDoList) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		ToDoList toDo = toDoRepository.findById(toDoList.getTaskID()).get();

		toDo.setTaskName(toDoList.getTaskName());
		toDo.setTaskDescription(toDoList.getTaskDescription());
		toDo.setStatus(toDoList.getStatus());
		toDo.setDueTime(toDoList.getDueTime());
		toDo.setCurrentDateTime(currentDateTime);
		return toDoRepository.save(toDo);
	}

	public void deleteListById(int id) {
		toDoRepository.deleteById(id);
	}

}
