package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Project_Info;

public interface ProjectRepository extends JpaRepository<Project_Info, Integer> {

}
