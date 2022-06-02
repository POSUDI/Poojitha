package com.VehicleProject.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VehicleProject.entity.User;
import com.VehicleProject.entity.Vehicle;
import com.VehicleProject.entity.VehicleBooking;
import com.VehicleProject.exception.UserNotFoundException;
import com.VehicleProject.exception.VehicleNotFoundException;
import com.VehicleProject.repository.VehicleBookingRepository;
import com.VehicleProject.repository.VehicleRepository;


@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleBookingRepository vehicleBookingRepository; 
	
	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		Vehicle savedVehicle = vehicleRepository.save(vehicle);
		return savedVehicle;
	}

	@Override
	public Vehicle getVehicleById(int vehicleId) {
		Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
		if(optionalVehicle.isEmpty())
		{
		throw new UserNotFoundException("User Not found with id:"+vehicleId);
	}
	Vehicle vehicle = optionalVehicle.get();
		return vehicle;
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		
		Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicle.getVehicleId());
		if(optionalVehicle.isEmpty())
		{
			throw new VehicleNotFoundException("Vehicle is not found with name:"+vehicle.getVehicleId());
		}
		Vehicle updatedCar = vehicleRepository.save(vehicle);
		return updatedCar;
	}

	@Override
	public void deleteVehicle(int carId) {
		
		Optional<Vehicle> optionalVehicle = vehicleRepository.findById(carId);
		if(optionalVehicle.isEmpty())
		{
			throw new VehicleNotFoundException("Vehicle is not found with id:"+carId);	
		}
		vehicleRepository.deleteById(carId);	
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles;
	}


	@Override
	public VehicleBooking bookingVehicle(Vehicle vehicle, User user) {
		VehicleBooking vehicleBooking = new VehicleBooking();
		vehicleBooking.setAmount(vehicle.getVehiclePrice());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		vehicleBooking.setBookingDate(date);
		vehicleBooking.setStatus("Pending");
		vehicleBooking.setBookingId(vehicleBooking.getBookingId());
		vehicleBooking.setVehicleId(vehicle.getVehicleId());
		vehicleBookingRepository.save(vehicleBooking);
		return vehicleBooking;
	}

	@Override
	public List<VehicleBooking> getAllBookingsbysuserId(int userId) {
		List<VehicleBooking> list= vehicleBookingRepository.getAllBookingsbyuserId(userId);
		return list;
	}

}
