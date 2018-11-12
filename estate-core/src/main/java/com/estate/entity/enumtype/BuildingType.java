package com.estate.entity.enumtype;

public enum  BuildingType {
	GROUND_FLOOR("Tầng trệt"),
	INTERIOR("Nội thất"),
	APARTMENT("Nguyên căn");

	private String name;

	BuildingType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
