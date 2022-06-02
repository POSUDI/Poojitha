package com.VehicleProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VehicleProject.entity.Feedback;
import com.VehicleProject.exception.FeedbackNotFoundException;
import com.VehicleProject.repository.FeedbackRepository;


@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Override
	public Feedback saveFeedback(Feedback feedback) {
		Feedback savedFeedback = feedbackRepository.save(feedback);
		return savedFeedback;
	}
	

	@Override
	public Feedback getFeedbackById(int feedbackById) {
		Optional<Feedback> optionalFeedback = feedbackRepository.findById(feedbackById);

		if (optionalFeedback.isEmpty()) {

			throw new FeedbackNotFoundException("Feedback Not found with id: " + feedbackById);
		}

		Feedback feedbacks = optionalFeedback.get();
		return feedbacks;
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		List<Feedback> feedbacks = feedbackRepository.findAll();
		return feedbacks;	
	}
}

	