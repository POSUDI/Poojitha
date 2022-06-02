package com.VehicleProject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VehicleProject.entity.Feedback;
import com.VehicleProject.entity.QueryText;
import com.VehicleProject.entity.User;
import com.VehicleProject.exception.UserNotFoundException;
import com.VehicleProject.repository.FeedbackRepository;
import com.VehicleProject.repository.QueryTextRepository;
import com.VehicleProject.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private QueryTextRepository querytextrepository;
	
	@Autowired
	private FeedbackRepository feedbackrepository;
	@Override
	public User saveUser(User user) {
	User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);		
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not found with id:"+userId);
		}
		User user = optionalUser.get();
		return user;
	
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public User updateUser(User user)
	{
		Optional<User> optionalProduct = userRepository.findById(user.getUserId());
		if(optionalProduct.isEmpty())
		{
			throw new UserNotFoundException("Product is not found with name:"+user.getUserId());
		}
		 User updatedUser = userRepository.save(user);
		return updatedUser;
		
		
	}

	@Override
	public QueryText saveQueryText(String querytext, int userId) {
		QueryText qtext = new QueryText();
		qtext.setDate(LocalDate.now());
		qtext.setQueryText(querytext);
		Optional<User> optionalUser = userRepository.findById(userId);



		if (optionalUser.isEmpty()) {



		throw new UserNotFoundException("user Not found with id: " + userId);
		}



		User user = optionalUser.get();
		qtext.setUser(user);
		return querytextrepository.save(qtext);
		}

	
	

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackrepository.save(feedback);
	}
}
