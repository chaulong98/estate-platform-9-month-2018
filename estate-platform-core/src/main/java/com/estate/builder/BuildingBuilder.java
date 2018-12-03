package com.estate.builder;

public class BuildingBuilder {



    private String buildingName;
    private Integer buildingArea;
    private String district;



    private String ward;
    private String street;
    private Integer areaFrom;
    private Integer areaTo;


    private Integer basementNumber;
    private String direction;
    private String level;
    private Integer costFrom;
    private Integer costTo;
    private String managerName;



    private String managerPhoneNumber;
    private String[] types = new String[]{};
    private String staffName;
    private String createdBy;
    private Long staffId;


    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Integer getBasementNumber() {
        return basementNumber;
    }

    public void setBasementNumber(Integer basementNumber) {
        this.basementNumber = basementNumber;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }
    public Integer getBuildingArea() {
        return buildingArea;
    }
    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public Integer getAreaFrom() {
        return areaFrom;
    }

    public Integer getAreaTo() {
        return areaTo;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getDirection() {
        return direction;
    }

    public String getLevel() {
        return level;
    }

    public Integer getCostFrom() {
        return costFrom;
    }

    public Integer getCostTo() {
        return costTo;
    }

    public String getManagerName() {
        return managerName;
    }



    public String[] getTypes() {
        return types;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Long getStaffId() {
        return staffId;
    }

    public BuildingBuilder(Builder builder) {
        this.buildingName = builder.buildingName;
        this.buildingArea = builder.buildingArea;
        this.district = builder.district;
        this.ward = builder.ward;
        this.street = builder.street;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.basementNumber = builder.basementNumber;
        this.direction = builder.direction;
        this.level = builder.level;
        this.costFrom = builder.costFrom;
        this.costTo = builder.costTo;
        this.managerName = builder.managerName;
        this.managerPhoneNumber = builder.managerPhoneNumber;
        this.types = builder.types;
        this.staffName = builder.staffName;
        this.staffId = builder.staffId;
        this.createdBy = builder.createdBy;
    }

    public static class Builder {
        private String buildingName;
        private Integer buildingArea;
        private String district;
        private String ward;
        private String street;
        private Integer areaFrom;
        private Integer areaTo;
        private Integer basementNumber;
        private String direction;
        private String level;
        private Integer costFrom;
        private Integer costTo;
        private String managerName;
        private String managerPhoneNumber;
        private String[] types = new String[]{};
        private String staffName;
        private String createdBy;
        private Long staffId;


        public Builder setBuildingArea(Integer buildingArea) {
            this.buildingArea = buildingArea;
            return this;
        }
        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
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

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
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

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }



        public Builder setTypes(String[] types) {
            this.types = types;
            return this;
        }

        public Builder setStaffName(String staffName) {
            this.staffName = staffName;
            return this;
        }

        public Builder setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingBuilder build() {
            return new BuildingBuilder(this);
        }




        public Builder setBuildingName(String buildingName) {
            this.buildingName = buildingName;
            return this;
        }
        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }



        public Builder setBasementNumber(Integer basementNumber) {
            this.basementNumber = basementNumber;
            return this;
        }
        public Builder setManagerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
            return this;
        }




    }
}
