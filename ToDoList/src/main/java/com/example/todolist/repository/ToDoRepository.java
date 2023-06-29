package com.example.todolist.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.model.ToDoList;

public interface ToDoRepository extends JpaRepository<ToDoList, Integer> {

	List<ToDoList> findByHitDateBetween(LocalDate startOfDay, LocalDate endOfDay);

	ToDoList findByTaskID(int id);

}
