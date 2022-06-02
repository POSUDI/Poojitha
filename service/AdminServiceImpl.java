package com.VehicleProject.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.VehicleProject.entity.Admin;
import com.VehicleProject.entity.User;
import com.VehicleProject.entity.Vehicle;
import com.VehicleProject.entity.VehicleBooking;
import com.VehicleProject.exception.AdminNotFoundException;
import com.VehicleProject.exception.PasswordMisMatchException;
import com.VehicleProject.exception.VehicleNotFoundException;
import com.VehicleProject.model.ChangePasswordRequest;
import com.VehicleProject.repository.AdminRepository;
import com.VehicleProject.repository.UserRepository;
import com.VehicleProject.repository.VehicleRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehicleBookingServiceImpl vehicleBookingServiceImpl;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private QueryTextServiceImpl queryTextServiceImpl;

	@Autowired
	private UserServiceImp userServiceImp;

	@Override
	public Admin saveAdmin(Admin admin) {
		Admin savedAdmin = adminRepository.save(admin);
		return savedAdmin;
	}

	@Override
	public Admin getAdminById(int adminId) 
	{
		Optional<Admin> optionalAdmin = adminRepository.findById(adminId);
		if(optionalAdmin.isEmpty())
		{
			throw new AdminNotFoundException("Admin Not Found with id:"+adminId);
		}
		Admin admin = optionalAdmin.get();
		return admin;
	}

	@Override
	public List<Admin> getAllAdmin() 
	{
		List<Admin> admins = adminRepository.findAll();
		return admins;

	}
	
	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		Vehicle savedVehicle = vehicleRepository.save(vehicle);
		return savedVehicle;
	}
	
	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicle.getVehicleId());

		if (optionalVehicle.isEmpty()) {
			throw new VehicleNotFoundException("Vehicle Not found with id: " + vehicle.getVehicleId());
		}
		
		Vehicle updatedVehicle = vehicleRepository.save(vehicle);
		return updatedVehicle;
	}


	@Override
	public String manageBooking(int booking_Id, String status) {
		VehicleBooking bookingObj = vehicleBookingServiceImpl.getVehicleBookingById(booking_Id);
		if(Objects.nonNull(bookingObj))
		{
			bookingObj.setStatus(status);
			vehicleBookingServiceImpl.saveVehicleBooking(bookingObj);
		}
		return "Success";
	}

	@Override
	public int getTotalUserCount() {
		return userServiceImp.getAllUsers().size();
	}

	@Override
	public int getTotalBookingcount() {
		return vehicleBookingServiceImpl.getAllVehicleBookings().size();
	}

	@Override
	public int getTotalQuerysCount() {
		return queryTextServiceImpl.getAllQueryText().size();
	}

	@Override
	public String changePassword(ChangePasswordRequest changePasswordRequest) {
		Optional<Admin> adminById = adminRepository.findById(changePasswordRequest.getAdminId());
		if (adminById.isEmpty()) {
			throw new AdminNotFoundException(changePasswordRequest.getAdminId() + "admin not found");
		}
		Admin admin = adminById.get();
		if (!admin.getAdminPassword().equals(changePasswordRequest.getOldpassword())) {
			throw new PasswordMisMatchException("old password not matching with new password"); }
		Admin newAdmin = new Admin();
		newAdmin.setAdminId(admin.getAdminId());
		newAdmin.setAdminAddress(admin.getAdminAddress());
		newAdmin.setAdminEmail(admin.getAdminEmail());
		newAdmin.setAdminGender(admin.getAdminGender());
		newAdmin.setAdminfirstName(admin.getAdminfirstName());
		newAdmin.setAdminlastName(admin.getAdminlastName());
		newAdmin.setAdminmobileNum(admin.getAdminmobileNum());
		newAdmin.setAdminUserName(admin.getAdminUserName());
		newAdmin.setAdminPassword(changePasswordRequest.getNewpassword()); 
		adminRepository.save(newAdmin); return "Password Updated Successfully.";
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();
		return users;
	}


	@Override
	public void deleteVehicle(int vehicleId) {
		Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
		if(optionalVehicle.isEmpty()) {
			throw new VehicleNotFoundException("Vehicle Not found with id:"+ vehicleId);

		}
		vehicleRepository.deleteById(vehicleId);

	}
}










	