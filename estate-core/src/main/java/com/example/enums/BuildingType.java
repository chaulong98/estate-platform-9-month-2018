package com.example.enums;

public enum BuildingType {
    GROUNDFLOOR("Tầng trệt"), ROOTCAUSE("Nguyên căn"), FURNITURE("Nội thất");

    private String name;

    private BuildingType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
