package com.estate.builder;

public class BuildingBuilder {
    private String name;
    private String district;
    private String ward;
    private String street;
    private String structure;
    private Integer basement;
    private Integer floorArea;
    private String direction;
    private String grade;
    private String managerName;
    private String managerPhone;
    private String type;
    private Integer costFrom;
    private Integer costTo;
    private Integer areaFrom;
    private Integer areaTo;
    private Long staffId;

    public BuildingBuilder (Builder builder){
        this.name = builder.name;
        this.district = builder.district;
        this.areaFrom = builder.areaFrom;
        this.areaTo = builder.areaTo;
        this.basement = builder.basement;
        this.costFrom = builder.costFrom;
        this.costTo = builder.costTo;
        this.direction = builder.direction;
        this.floorArea = builder.floorArea;
        this.grade = builder.grade;
        this.managerName = builder.managerName;
        this.managerPhone = builder.managerPhone;
        this.type = builder.type;
        this.staffId = builder.staffId;
        this.street = builder.street;
        this.structure = builder.structure;
        this.ward = builder.ward;
    }

    public String getName() {
        return name;
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

    public String getStructure() {
        return structure;
    }

    public Integer getBasement() {
        return basement;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public String getDirection() {
        return direction;
    }

    public String getGrade() {
        return grade;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public String getType() {
        return type;
    }

    public Integer getCostFrom() {
        return costFrom;
    }

    public Integer getCostTo() {
        return costTo;
    }

    public Integer getAreaFrom() {
        return areaFrom;
    }

    public Integer getAreaTo() {
        return areaTo;
    }

    public Long getStaffId() {
        return staffId;
    }


    public static class Builder{
        private String name;
        private String district;
        private String ward;
        private String street;
        private String structure;
        private Integer basement;
        private Integer floorArea;
        private String direction;
        private String grade;
        private String managerName;
        private String managerPhone;
        private String type;
        private Integer costFrom;
        private Integer costTo;
        private Integer areaFrom;
        private Integer areaTo;
        private Long staffId;

        public Builder setName(String name) {
            this.name = name;
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

        public Builder setStructure(String structure) {
            this.structure = structure;
            return this;
        }

        public Builder setBasement(Integer basement) {
            this.basement = basement;
            return this;
        }

        public Builder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setGrade(String grade) {
            this.grade = grade;
            return this;
        }

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setManagerPhone(String managerPhone) {
            this.managerPhone = managerPhone;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
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

        public Builder setAreaFrom(Integer areaFrom) {
            this.areaFrom = areaFrom;
            return this;
        }

        public Builder setAreaTo(Integer areaTo) {
            this.areaTo = areaTo;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public BuildingBuilder build(){
            return new BuildingBuilder(this);
        }
    }
}
