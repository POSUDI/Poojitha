package com.VehicleProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VehicleProject.entity.User;
import com.VehicleProject.entity.Vehicle;
import com.VehicleProject.entity.VehicleBooking;
import com.VehicleProject.exception.UserNotFoundException;
import com.VehicleProject.exception.VehicleBookingNotFoundException;
import com.VehicleProject.repository.VehicleBookingRepository;

@Service
public class VehicleBookingServiceImpl implements VehicleBookingService  {

	@Autowired
	private VehicleBookingRepository vehiclebookingrepository;

	@Override
	public VehicleBooking saveVehicleBooking(VehicleBooking vehiclebooking) {
		VehicleBooking savedVehicleBooking = vehiclebookingrepository.save(vehiclebooking);
		return savedVehicleBooking;

	}


	@Override
	public List<VehicleBooking> getAllVehicleBookings() {
		List<VehicleBooking> vehiclebookings = vehiclebookingrepository.findAll();
		return vehiclebookings;
	}



	@Override
	public VehicleBooking getVehicleBookingById(int vehiclebookingId) {
		Optional<VehicleBooking> optionalVehicleBooking = vehiclebookingrepository.findById(vehiclebookingId);
		if(optionalVehicleBooking.isEmpty())
		{
			throw new UserNotFoundException("User Not found with id:"+vehiclebookingId);
		}
		VehicleBooking vehiclebooking = optionalVehicleBooking.get();
		return vehiclebooking;
	}
	
	@Override
	public List<VehicleBooking> getAllUserBooking(int userId) {
		List<VehicleBooking> optionalVehicleBooking =  vehiclebookingrepository.getAllBookingsbyuserId(userId);
		/*
		 * if (optionalVehicleBooking.isEmpty()) {
		 * 
		 * throw new VehicleBookingNotFoundException("User Not found with id: " +
		 * userId); }
		 */

		return optionalVehicleBooking;
	}

}
		
	


