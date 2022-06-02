package com.VehicleProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VehicleProject.entity.Feedback;



public interface FeedbackRepository extends JpaRepository<Feedback,Integer>
{	 

}
