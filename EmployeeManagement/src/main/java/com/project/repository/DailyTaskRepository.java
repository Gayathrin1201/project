package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.model.DailyTaskTracker;
import com.project.model.UserInfo;


public interface DailyTaskRepository extends JpaRepository<DailyTaskTracker, Long>{
	@Modifying
@Query(value="UPDATE daily_task_tracker d SET project_name = ( SELECT project_name from project_info p WHERE p.project_id=d.id)",nativeQuery = true)
    void updateProjectName();

	@Modifying
@Query(value="UPDATE daily_task_tracker d SET client_name = ( SELECT client_name from project_info p WHERE p.project_id=d.id)",nativeQuery = true)
    void updateClientName();
	@Modifying
	@Query(value="UPDATE daily_task_tracker d SET employee_assigned_name = ( SELECT employee_assigned_name from project_info p WHERE p.project_id=d.id)",nativeQuery = true)
	    void updateEmployeeName();

	//DailyTaskTracker findByUserAndLogOutTimeIsNull(UserInfo userinfo);

}
