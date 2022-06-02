package com.VehicleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.VehicleProject.entity.VehicleBooking;
import com.VehicleProject.service.VehicleBookingService;



@RestController
public class VehicleBookingController {
	
	@Autowired
	private VehicleBookingService vehiclebookingService;
	
	@PostMapping("/vehiclebooking/save")
	public ResponseEntity<VehicleBooking> addVehicleBooking(@RequestBody VehicleBooking vehiclebooking)
	{
	VehicleBooking newVehicleBooking = vehiclebookingService.saveVehicleBooking(vehiclebooking);
	ResponseEntity<VehicleBooking> responseEntity = new ResponseEntity<>(newVehicleBooking,HttpStatus.CREATED);//respentity..refvar
	return responseEntity;
	}


	 @GetMapping("/vehiclebooking/all")
	 public List<VehicleBooking> fetchAllVehicleBookings() {
	
	return vehiclebookingService.getAllVehicleBookings();
	 }
	
	@GetMapping("/vehiclebooking/find/{vbId}")
	public ResponseEntity<Object> fetchUserById(@PathVariable("vbId") int vehicleBookingId) {

	ResponseEntity<Object> responseEntity = null;
	VehicleBooking vehiclebooking = vehiclebookingService.getVehicleBookingById(vehicleBookingId);
	responseEntity = new ResponseEntity<>(vehiclebooking,HttpStatus.OK);
	return responseEntity;
	}

	@GetMapping("/uservehiclebooking/all")
	public List<VehicleBooking> fetchAllProducts() {

	List<VehicleBooking> vehiclebookingList = vehiclebookingService.getAllVehicleBookings();

	return vehiclebookingList;
	}
}
