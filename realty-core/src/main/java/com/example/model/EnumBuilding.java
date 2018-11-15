package com.example.model;

import java.util.ArrayList;
import java.util.List;

public enum EnumBuilding {

	TANGTRET("tang_tret", "Tầng Trệt"), NGUYENCAN("nguyen_can", "Nguyên Căn"), NOITHAT("noi_that", "Nội Thất");

	private String code;
	private String name;

	private EnumBuilding(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static List<BuildingType> getTypeBuildings() {
		List<BuildingType> buildingTypes = new ArrayList<>();
		for (EnumBuilding item : EnumBuilding.values()) {
			BuildingType buildingType = new BuildingType();
			buildingType.setCode(item.code);
			buildingType.setName(item.name);
			buildingTypes.add(buildingType);
		}
		return buildingTypes;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
