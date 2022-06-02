package com.VehicleProject.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VehicleProject.entity.User;
import com.VehicleProject.entity.Vehicle;
import com.VehicleProject.entity.VehicleBooking;
import com.VehicleProject.service.UserService;
import com.VehicleProject.service.VehicleBookingService;
import com.VehicleProject.service.VehicleService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleBookingService vehicleBookingService;
	
	@PostMapping("/user/save")
	public ResponseEntity<User> addUser(@RequestBody User user) { //req body...to take input frm user
		User newUser = userService.saveUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(newUser,HttpStatus.CREATED);//respentity..refvar
		return responseEntity;
	}
	
	@GetMapping("/user/all")
	public List<User> fetchAllProducts() {

		List<User> userList = userService.getAllUsers(); //
		
		return userList;
	}
	
	@GetMapping("/user/find/{uId}")
	public ResponseEntity<Object> fetchUserById(@PathVariable("uId") int userId) {
		
		ResponseEntity<Object> responseEntity = null;		
		User user = userService.getUserById(userId);	
		responseEntity = new ResponseEntity<>(user,HttpStatus.OK);				
		return responseEntity;
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<User> modifyProduct(@RequestBody User user)
	{
		User updatedUser = userService.updateUser(user);
		userService.updateUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(updatedUser,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/user/book/{vehicleId}/{userId}")
	public ResponseEntity<VehicleBooking> bookvehicle(@PathVariable("vehicleId") int vehicleId,@PathVariable("userId") int userId) {
		VehicleBooking vehicleBooking = new VehicleBooking();
		List<VehicleBooking> list = vehicleBookingService.getAllUserBooking(userId);
		Vehicle vehicle= vehicleService.getVehicleById(vehicleId);
		User user =userService.getUserById(userId);
		
		if(Objects.nonNull(vehicle) && Objects.nonNull(user)) {
			vehicleBooking=vehicleService.bookingVehicle(vehicle,user);
			list.add(vehicleBooking);
//			user.setlistOfBookings(list);
			if(Objects.nonNull(vehicleBooking)) {
				userService.updateUser(user);
			}
		}		
		ResponseEntity<VehicleBooking> responseEntity = new ResponseEntity<>(vehicleBooking,HttpStatus.OK);
		return responseEntity;
	}	
	}


