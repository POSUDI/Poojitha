package com.VehicleProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VehicleProject.entity.Feedback;

@Service
public interface FeedbackService {
	
	public Feedback saveFeedback(Feedback feedback);
	
	public Feedback getFeedbackById(int feedbackId);

	public List<Feedback> getAllFeedbacks();
}
