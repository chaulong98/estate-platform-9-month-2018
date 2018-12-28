package com.example.builder;

public class BuildingBuilder {
    private String buildingName;
    private String district;
    private String ward;
    private String street;
    private Integer basementArea;
    private Integer basementNumber;
    private String direction;
    private String level;
    private String managerName;
    private String phoneNumber;
    private String[] productType = new String[]{};
    private Integer areaFrom;
    private Integer areaTo;
    private Integer costFrom;
    private Integer costTo;
    private Long staffId;

    private BuildingBuilder(){
    }

    public String getBuildingName() {
        return buildingName;
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

    public Integer getBasementArea() {
        return basementArea;
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

    public String[] getProductType() {
        return productType;
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

    public void print(){
        System.out.println("aaa");
    }

    public static class Builder {
        private String buildingName;
        private String district;
        private String ward;
        private String street;
        private Integer basementArea;
        private Integer basementNumber;
        private String direction;
        private String level;
        private String managerName;
        private String phoneNumber;
        private String[] productType = new String[]{};
        private Integer areaFrom;
        private Integer areaTo;
        private Integer costFrom;
        private Integer costTo;
        private Long staffId;

        public Builder setbuildingName(String buildingName) {
            this.buildingName = buildingName;
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

        public Builder setBasementArea(Integer basementArea) {
            this.basementArea = basementArea;
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

        public Builder setProductType(String[] productType) {
            this.productType = productType;
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
            BuildingBuilder building = new BuildingBuilder();
            building.buildingName = this.buildingName;
            building.district = this.district;
            building.ward = this.ward;
            building.street = this.street;
            building.basementArea = this.basementArea;
            building.basementNumber = this.basementNumber;
            building.direction = this.direction;
            building.level = this.level;
            building.managerName = this.managerName;
            building.phoneNumber = this.phoneNumber;
            building.productType = this.productType;
            building.areaFrom = this.areaFrom;
            building.areaTo = this.areaTo;
            building.costFrom = this.costFrom;
            building.costTo = this.costTo;
            building.staffId = this.staffId;

            return building;
        }
    }
}
