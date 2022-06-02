package com.VehicleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VehicleProject.entity.Feedback;
import com.VehicleProject.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
//	@PostMapping("/feedback/save")
//	public ResponseEntity<Feedback> addfeedback(@RequestBody Feedback feedback)
//	{
//	Feedback newFeedback = feedbackService.saveFeedback(feedback);
//	ResponseEntity<Feedback> responseEntity = new ResponseEntity<>(newFeedback,HttpStatus.CREATED);//respentity..refvar
//	return responseEntity;
//	}
	
	 @GetMapping("/feedback/all")
	 public List<Feedback> fetchAllFeedbacks() {
	
	return feedbackService.getAllFeedbacks();
	 }
	 
	 @GetMapping("/feedback/find/{fbId}")
		public ResponseEntity<Object> fetchUserById(@PathVariable("fbId") int feedbackId) {
			
			ResponseEntity<Object> responseEntity = null;		
			Feedback feedback = feedbackService.getFeedbackById(feedbackId);	
			responseEntity = new ResponseEntity<>(feedback,HttpStatus.OK);				
			return responseEntity;
		}
}



