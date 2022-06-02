package com.VehicleProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VehicleProject.entity.User;



public interface UserRepository extends JpaRepository<User,Integer>
{
	
}
