package com.VehicleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.VehicleProject.entity.Admin;
import com.VehicleProject.entity.User;
import com.VehicleProject.entity.Vehicle;
import com.VehicleProject.model.ChangePasswordRequest;
import com.VehicleProject.service.AdminService;
import com.VehicleProject.service.UserService;
import com.VehicleProject.service.VehicleService;


@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/admin/save")
	public ResponseEntity<Admin> addUser(@RequestBody Admin admin) {

		Admin newAdmin = adminService.saveAdmin(admin);
		ResponseEntity<Admin> responseEntity = new ResponseEntity<>(newAdmin,HttpStatus.CREATED);
		return responseEntity;
	}
	@GetMapping("/admin/find/{aId}")
	public ResponseEntity<Object> fetchUserById(@PathVariable("aId") int adminId) {

		ResponseEntity<Object> responseEntity = null;		
		Admin admin = adminService.getAdminById(adminId);	
		responseEntity = new ResponseEntity<>(admin,HttpStatus.OK);				
		return responseEntity;
	}
	@GetMapping("/admin/all")
	public List<Admin> fetchAllProducts() {

		List<Admin> adminList = adminService.getAllAdmin();

		return adminList;
	}
	
	@PostMapping("/vehicle/save")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
	
		Vehicle newVehicle = vehicleService.saveVehicle(vehicle);
		return new ResponseEntity<>(newVehicle,HttpStatus.CREATED);
	}

	@PutMapping("/vehicle/update")
	public ResponseEntity<Vehicle> modifyVehicles(@RequestBody Vehicle vehicle) {

		Vehicle updatedVehicle = vehicleService.updateVehicle(vehicle);

		return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
	}


	@DeleteMapping("/vehicle/delete/{vehicleId}")
	public ResponseEntity<String> removeVehicles(@PathVariable("vehicleId") int vehicleId) {

		vehicleService.deleteVehicle(vehicleId);

		return new ResponseEntity<>("Vehicle Deleted Successfully.", HttpStatus.OK);
	}


	@PutMapping("/admin/manageBooking/{id}")
	public String manageBooking(@PathVariable("id") int bookingId ,@RequestBody String status) {

		return  adminService.manageBooking(bookingId,status);
	}

	@GetMapping("/admin/totalusercount")
	public int getTotalUser() {

		return  adminService.getTotalUserCount();
	}

	@GetMapping("/admin/totalbookingcount")
	public int getTotalBookingcount() {

		return  adminService.getTotalBookingcount();
	}

	@GetMapping("/admin/totalqueryscount")
	public int getTotalQuerysCount() {

		return  adminService.getTotalQuerysCount();
	}

	@GetMapping("/user/getall")
	public List<User> fetchAllUser() {
		return userService.getAllUsers();
	}

	
	@PutMapping("/admin/changePassword")
	public String changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
		String adminPassword = adminService.changePassword(changePasswordRequest);
		return adminPassword;
	}
}