package com.VehicleProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "admin_id")
	private int adminId;
	
	@Column(name = "adminfirst_name")
	private String adminfirstName;
	
	@Column(name = "adminlast_name")
	private String adminlastName;
	
	@Column(name = "adminmobile_num")
	private long adminmobileNum;
	
	@Column(name = "admin_email")
	private String adminEmail;
	
	@Column(name = "admin_age")
	private int adminAge;
	
	@Column(name = "admin_gender")
	private String adminGender;
	
	@Column(name = "admin_address")
	private String adminAddress;
	
	@Column(name = "admin_Username")
	private String adminUserName;
	
	@Column(name = "admin_password")
	private String adminPassword;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminfirstName() {
		return adminfirstName;
	}

	public void setAdminfirstName(String adminfirstName) {
		this.adminfirstName = adminfirstName;
	}

	public String getAdminlastName() {
		return adminlastName;
	}

	public void setAdminlastName(String adminlastName) {
		this.adminlastName = adminlastName;
	}

	public long getAdminmobileNum() {
		return adminmobileNum;
	}

	public void setAdminmobileNum(long adminmobileNum) {
		this.adminmobileNum = adminmobileNum;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public int getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}

	