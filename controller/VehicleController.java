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

import com.VehicleProject.entity.Vehicle;
import com.VehicleProject.service.VehicleService;



@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
//	@PostMapping("/vehicle/save")
//	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle)
//	{
//	Vehicle newVehicle = vehicleService.saveVehicle(vehicle);
//	ResponseEntity<Vehicle> responseEntity = new ResponseEntity<>(newVehicle,HttpStatus.CREATED);//respentity..refvar
//	return responseEntity;
//}
	 @GetMapping("/vehicle/find/{vId}")
	 public ResponseEntity<Object> fetchVehicleById(@PathVariable("vId") int vehicleId)
	 {
		 ResponseEntity<Object> responseEntity = null;
		 Vehicle fetchvehicle=vehicleService.getVehicleById(vehicleId);//to throw excep if data not present
			responseEntity = new ResponseEntity<>(fetchvehicle,HttpStatus.OK);
			return responseEntity;
		}
	 @GetMapping("/vehicle/all")
	 public List<Vehicle> fetchAllVehicles() {
	
	List<Vehicle> vehicleList = vehicleService.getAllVehicles();
	return vehicleList;
}
}

//@PutMapping("/vehicle/update")
//public ResponseEntity<Vehicle> modifyProduct(@RequestBody Vehicle vehicle)
//{
//	Vehicle updatedVehicle = vehicleService.updateVehicle(vehicle);
//	ResponseEntity<Vehicle> responseEntity = new ResponseEntity<>(updatedVehicle,HttpStatus.OK);
//	return responseEntity;
//}

//@DeleteMapping("/vehicle/find/{vid}")
//public ResponseEntity<String> deleteVehcile(@PathVariable("vid") int carId)
//{
//	vehicleService.deleteVehicle(carId);
//	ResponseEntity<String> responseEntity = new ResponseEntity<>("Vehicle deleted sucessfully",HttpStatus.OK);
//	return responseEntity;
//}
//}
