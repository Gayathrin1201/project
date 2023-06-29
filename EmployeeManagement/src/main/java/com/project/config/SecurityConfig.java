package com.project.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.project.model.DailyTaskTracker;
import com.project.model.Project_Info;
import com.project.model.UserInfo;
import com.project.repository.DailyTaskRepository;
import com.project.repository.ProjectRepository;
import com.project.repository.UserInfoRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	private UserInfoRepository repository;
	@Autowired
	private DailyTaskRepository dailyTaskRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Bean
	public UserDetailsService userDetailsService() {

		return new UserInfoUserDetailsService();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeHttpRequests()

				.requestMatchers("/new", "/getdetail", "/addDetails", "/updateProject","/employeebyid/{id}").permitAll().and()
				.authorizeHttpRequests().requestMatchers("/admin").authenticated().and()
				.authorizeHttpRequests().requestMatchers( "/updateNumberOfEmployees").authenticated().and().httpBasic()
				/*
				 * .successHandler((request, response, authentication) -> { String username =
				 * authentication.getName(); UserInfo userinfo =
				 * repository.findByName(username); DailyTaskTracker userLogin = new
				 * DailyTaskTracker(); userLogin.setUser(userinfo); userLogin.setLoginTime(new
				 * Date()); // dailyTaskRepository.save(userLogin);
				 * response.sendRedirect("/employeebyid/2");
				 * }).permitAll().and().logout().logoutSuccessHandler((request, response,
				 * authentication) -> { String username = authentication.getName(); UserInfo
				 * userinfo = repository.findByName(username); DailyTaskTracker loginDetails =
				 * dailyTaskRepository.findByUserAndLogOutTimeIsNull(userinfo);
				 * 
				 * loginDetails.setUser(userinfo); loginDetails.setLogOutTime(new Date());
				 * double hoursWorked = loginDetails.getHoursWorked();
				 * loginDetails.setHours_worked(hoursWorked);
				 * dailyTaskRepository.save(loginDetails); response.sendRedirect("/login"); })
				 */.and().build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

}
