
package com.VehicleProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VehicleProject.entity.User;
import com.VehicleProject.entity.Vehicle;
import com.VehicleProject.entity.VehicleBooking;

@Service
public interface VehicleService {

	public Vehicle saveVehicle(Vehicle vehicle);
	
	public Vehicle getVehicleById(int vehicleId);
	
	public List<Vehicle> getAllVehicles();
	
public VehicleBooking bookingVehicle(Vehicle vehicle,User user);
	
	public List<VehicleBooking> getAllBookingsbysuserId(int userId);
	
	public Vehicle updateVehicle(Vehicle vehicle);//
	
	public void deleteVehicle(int VehicleId);//

}
