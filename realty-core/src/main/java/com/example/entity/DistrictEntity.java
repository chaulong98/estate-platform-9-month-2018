package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 74036220693848531L;
	private String name;
	private String code;

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

}
