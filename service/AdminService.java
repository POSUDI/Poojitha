package com.VehicleProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VehicleProject.entity.Admin;
import com.VehicleProject.entity.User;
import com.VehicleProject.entity.Vehicle;
import com.VehicleProject.model.ChangePasswordRequest;

@Service
public interface AdminService {
	
	public Admin saveAdmin(Admin admin);

	public Admin getAdminById(int adminId);
	
	public Vehicle createVehicle(Vehicle vehicle);
	
	public Vehicle updateVehicle(Vehicle vehicle);
	 
	public void deleteVehicle(int vehicleId);

	public List<Admin> getAllAdmin();
	
	public String manageBooking(int booking_Id,String status);
	
	public int getTotalUserCount();
	
	public int getTotalBookingcount();
	
	public int getTotalQuerysCount();
	
	public List<User> getAllUser();
	
	public String changePassword(ChangePasswordRequest changePasswordRequest);

}
