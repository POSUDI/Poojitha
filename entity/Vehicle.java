package com.VehicleProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_table")
public class Vehicle {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private int vehicleId;
	
	@Column(name = "vehicle_brand")
	private String vehicleBrand;
	
	@Column(name = "vehicle_maker")
	private String vehicleMaker;
	
	@Column(name = "vehicle_name")
	private String vehicleName;
	
	@Column(name = "vehicle_color")
	private String vehicleColor;
	
	@Column(name = "seating_capacity")
	private int seatingCapacity;
	
	@Column(name = "vehicle_no")
	private String vehicleNo;
	
	@Column(name = "vehicle_price")
	private int vehiclePrice;

	
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleMaker() {
		return vehicleMaker;
	}

	public void setVehicleMaker(String vehicleMaker) {
		this.vehicleMaker = vehicleMaker;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public int getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(int vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
}

		