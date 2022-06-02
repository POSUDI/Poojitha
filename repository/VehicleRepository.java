package com.VehicleProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VehicleProject.entity.Vehicle;

public interface VehicleRepository  extends JpaRepository<Vehicle,Integer>
{

}
