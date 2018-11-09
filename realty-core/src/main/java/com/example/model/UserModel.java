package com.example.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;

public class UserModel extends AbstractModel<UserModel> {

	private static final long serialVersionUID = 1L;

	private String userName;

	private String password;

	private String fullName;

	private String email;

	private String phoneNumber;
   
	private Map<String, String> mapRole;
	
	private String selectorRole;
	
	private Boolean checkUserAndEmail = true;
	
	private Integer status;
	private List<RoleModel> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}

	public Map<String, String> getMapRole() {
		return mapRole;
	}

	public void setMapRole(Map<String, String> mapRole) {
		this.mapRole = mapRole;
	}

	public String getSelectorRole() {
		return selectorRole;
	}

	public void setSelectorRole(String selectorRole) {
		this.selectorRole = selectorRole;
	}

	public Boolean getCheckUserAndEmail() {
		return checkUserAndEmail;
	}

	public void setCheckUserAndEmail(Boolean checkUserAndEmail) {
		this.checkUserAndEmail = checkUserAndEmail;
	}

	



}
