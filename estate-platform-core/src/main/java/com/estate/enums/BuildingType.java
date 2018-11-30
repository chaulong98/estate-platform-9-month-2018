package com.estate.enums;

public enum BuildingType {
    groundFloor("Tầng trệt"),
    rootCause("Nguyên căn"),
    furniture("Nội thất");

    private String name;

    BuildingType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
