package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private String name;

	@Column
	private String code;

	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
	private List<UserEntity> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

}
