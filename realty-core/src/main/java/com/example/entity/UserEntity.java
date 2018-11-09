package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private String userName;

	@Column
	private String password;

	@Column
	private String fullName;

	@Column
	private String email;

	@Column
	private String phoneNumber;

	@Column
	private Integer status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", nullable = false) })

	private List<RoleEntity> roles;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "userEntity")
	private List<BuildingEntity> building;

	public List<BuildingEntity> getBuilding() {
		return building;
	}

	public void setBuilding(List<BuildingEntity> building) {
		this.building = building;
	}

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

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

}
