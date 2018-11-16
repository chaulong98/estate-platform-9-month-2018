package com.estate.constant;

import org.springframework.stereotype.Component;

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
