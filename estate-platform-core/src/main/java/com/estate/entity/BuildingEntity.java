package com.estate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    private static final long serialVersionUID = -2853379557934065188L;

    @Column
    private String buildingName;

    @Column
    private String district;

    @Column
    private String ward;

    @Column
    private String street;

    @Column
    private String structure;

    @Column
    private Integer basementNumber;

    @Column
    private Integer buildingArea;

    @Column
    private String direction;

    @Column
    private String level;

    @Column
    private String rentArea;

    @Column
    private String descriptionArea;

    @Column
    private Integer rentCost;

    @Column
    private String descriptionCost;

    @Column
    private String serviceCost;

    @Column
    private String carCost;

    @Column
    private String motorbikeCost;

    @Column
    private String overtimeCost;

    @Column
    private String electricityCost;

    @Column
    private String deposit;

    @Column
    private String pay;

    @Column
    private String rentTime;

    @Column
    private String decorateTime;

    @Column
    private String managerName;

    @Column
    private String managerPhoneNumber;

    @Column
    private String brokerageFees;

    @Column
    private String type;

    @Column
    private String note;

    @Column
    private String link;

    @Column
    private String location;

    @Column
    private String image;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_building", joinColumns = {
            @JoinColumn(name = "building_id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "user_id", nullable = false)})
    private List<UserEntity> staffs = new ArrayList<>();

    public List<UserEntity> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<UserEntity> staffs) {
        this.staffs = staffs;
    }
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Integer getBasementNumber() {
        return basementNumber;
    }

    public void setBasementNumber(Integer basementNumber) {
        this.basementNumber = basementNumber;
    }

    public Integer getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Integer buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public String getDescriptionArea() {
        return descriptionArea;
    }

    public void setDescriptionArea(String descriptionArea) {
        this.descriptionArea = descriptionArea;
    }

    public Integer getRentCost() {
        return rentCost;
    }

    public void setRentCost(Integer rentCost) {
        this.rentCost = rentCost;
    }

    public String getDescriptionCost() {
        return descriptionCost;
    }

    public void setDescriptionCost(String descriptionCost) {
        this.descriptionCost = descriptionCost;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getCarCost() {
        return carCost;
    }

    public void setCarCost(String carCost) {
        this.carCost = carCost;
    }

    public String getMotorbikeCost() {
        return motorbikeCost;
    }

    public void setMotorbikeCost(String motorbikeCost) {
        this.motorbikeCost = motorbikeCost;
    }

    public String getOvertimeCost() {
        return overtimeCost;
    }

    public void setOvertimeCost(String overtimeCost) {
        this.overtimeCost = overtimeCost;
    }

    public String getElectricityCost() {
        return electricityCost;
    }

    public void setElectricityCost(String electricityCost) {
        this.electricityCost = electricityCost;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getDecorateTime() {
        return decorateTime;
    }

    public void setDecorateTime(String decorateTime) {
        this.decorateTime = decorateTime;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public String getBrokerageFees() {
        return brokerageFees;
    }

    public void setBrokerageFees(String brokerageFees) {
        this.brokerageFees = brokerageFees;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
