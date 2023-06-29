package com.example.todolist.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.todolist.model.ToDoList;
import com.example.todolist.service.ToDoService;

@Controller

public class ToDoController {
	Logger logger = LoggerFactory.getLogger(ToDoController.class);
	@Autowired
	private ToDoService toDoService;

	@GetMapping("/home")
	public String dataTask(@ModelAttribute ToDoList dataEntity, Model model) {
		List<ToDoList> datalist = toDoService.getListByDate();
		model.addAttribute("datalist", datalist);
		logger.info("Get details");
		return "home";
	}

	@PostMapping("/home")
	public String saveList(@ModelAttribute("data") ToDoList toDoList, Model model) {
		toDoService.addList(toDoList);

		List<ToDoList> datalist = toDoService.getListByDate();
		model.addAttribute("datalist", datalist);
		logger.info("Add all details");
		return "home";
	}

	@GetMapping("/getList")
	public List<ToDoList> findAllList() {
		logger.info("Get all  details");
		return toDoService.getAllList();

	}

	@GetMapping("/getListById/{id}")
	public String showFormForUpdate(@PathVariable String id, Model model) {

		ToDoList toDoList = toDoService.getListById(Integer.parseInt(id));

		model.addAttribute("task", toDoList);
		logger.info("Get details by ID");
		return "new";
	}

	@GetMapping("/getListByDate")
	public List<ToDoList> getListByDate() {
		logger.info("Get details by Date");
		return toDoService.getListByDate();
	}

	@PostMapping("/update/{id}")
	public String updatedList(@PathVariable String id, @ModelAttribute("task") ToDoList toDoList, Model model) {

		ToDoList existingtoDo = toDoService.getListById(Integer.parseInt(id));

		existingtoDo.setTaskName(toDoList.getTaskName());
		existingtoDo.setTaskDescription(toDoList.getTaskDescription());
		existingtoDo.setStatus(toDoList.getStatus());
		existingtoDo.setDueTime(toDoList.getDueTime());
		existingtoDo.setTaskID(Integer.parseInt(id));
		toDoService.updateList(existingtoDo);
		logger.info("Update details by ID");
		return "redirect:/home";
	}

	@GetMapping("/deleteById/{id}")
	public String deleteListById(@PathVariable int id) {
		toDoService.deleteListById(id);
		logger.info("Delete details by Id");
		return "redirect:/home";
	}

}
