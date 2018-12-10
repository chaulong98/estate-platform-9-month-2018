package com.estate.builder;

public class BuildingBuilder {

    private String productName;
    private String district;
    private String ward;
    private String street;
    private Integer buildingArea;
    private Integer basementNumber;
    private String direction;
    private String level;
    private String managerName;
    private String phoneNumber;
    private String[] typeBuilding = new String[]{};
    private Integer areaFrom;
    private Integer areaTo;
    private Integer costFrom;
    private Integer costTo;
    private Long staffId;

    public BuildingBuilder(Builder builder) {
        this.productName = builder.productName;
        this.district = builder.district;
        this.ward = builder.ward;
        this.street = builder.street;
        this.buildingArea = builder.buildingArea;
        this.basementNumber = builder.basementNumber;
        this.direction = builder.direction;
        this.level = builder.level;
        this.managerName = builder.managerName;
        this.phoneNumber = builder.phoneNumber;
        this.typeBuilding = builder.typeBuilding;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.costFrom = builder.costFrom;
        this.costTo = builder.costTo;
        this.staffId = builder.staffId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Integer getBuildingArea() {
        return buildingArea;
    }

    public Integer getBasementNumber() {
        return basementNumber;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String[] getTypeBuilding() {
        return typeBuilding;
    }

    public Integer getAreaFrom() {
        return areaFrom;
    }

    public Integer getAreaTo() {
        return areaTo;
    }

    public Integer getCostFrom() {
        return costFrom;
    }

    public Integer getCostTo() {
        return costTo;
    }

    public Long getStaffId() {
        return staffId;
    }

    public static class Builder {
        private String productName;
        private String district;
        private String ward;
        private String street;
        private Integer buildingArea;
        private Integer basementNumber;
        private String direction;
        private String level;
        private String managerName;
        private String phoneNumber;
        private String[] typeBuilding = new String[]{};
        private Integer areaFrom;
        private Integer areaTo;
        private Integer costFrom;
        private Integer costTo;
        private Long staffId;

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setBuildingArea(Integer buildingArea) {
            this.buildingArea = buildingArea;
            return this;
        }

        public Builder setBasementNumber(Integer basementNumber) {
            this.basementNumber = basementNumber;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setTypeBuilding(String[] typeBuilding) {
            this.typeBuilding = typeBuilding;
            return this;
        }

        public Builder setAreaFrom(Integer areaFrom) {
            this.areaFrom = areaFrom;
            return this;
        }

        public Builder setAreaTo(Integer areaTo) {
            this.areaTo = areaTo;
            return this;
        }

        public Builder setCostFrom(Integer costFrom) {
            this.costFrom = costFrom;
            return this;
        }

        public Builder setCostTo(Integer costTo) {
            this.costTo = costTo;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingBuilder build() {
            return new BuildingBuilder(this);
        }
    }
}
