package com.VehicleProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VehicleProject.entity.VehicleBooking;

@Service
public interface VehicleBookingService 
{
	public VehicleBooking saveVehicleBooking(VehicleBooking vehiclebooking);
	
	public VehicleBooking getVehicleBookingById(int vehiclebookingId);
	
	public List<VehicleBooking> getAllVehicleBookings();
	
	public List<VehicleBooking> getAllUserBooking(int userId);
	

}
