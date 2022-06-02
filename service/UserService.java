package com.VehicleProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VehicleProject.entity.Feedback;
import com.VehicleProject.entity.QueryText;
import com.VehicleProject.entity.User;



@Service
public interface UserService {
	
public User saveUser(User user);//incomplete methods(gives ;)
	
	public User getUserById(int userId);
	
	public List<User> getAllUsers();//list to store
	
	public User updateUser(User user);
	
	public QueryText saveQueryText(String querytext, int userId);
	
	public Feedback saveFeedback(Feedback feedback);
	
	

}
