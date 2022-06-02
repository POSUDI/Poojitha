package com.VehicleProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class ChangePasswordRequest {
	
	
	private int AdminId;
	private String oldpassword;
	private String newpassword;
	
	
	public String getOldpassword() {
	return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
	this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
	return newpassword;
	}
	public void setNewpassword(String newpassword) {
	this.newpassword = newpassword;
	}
	public int getAdminId() {
	return AdminId;
	}
	public void setAdminId(int adminId) {
	AdminId = adminId;
	}

}
