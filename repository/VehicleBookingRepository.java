package com.VehicleProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.VehicleProject.entity.VehicleBooking;

public interface VehicleBookingRepository extends JpaRepository<VehicleBooking,Integer>{

	@Query("select b from VehicleBooking b where b.userId = :userId")
	List<VehicleBooking> getAllBookingsbyuserId(@Param("userId") int userId);

}
