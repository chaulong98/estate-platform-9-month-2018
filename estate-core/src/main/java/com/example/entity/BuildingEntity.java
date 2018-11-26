package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String buildingName;

    @Column
    private Integer district;

    @Column
    private String ward;

    @Column
    private String street;

    @Column
    private String structure;

    @Column
    private Integer basementNumber;

    @Column
    private String direction;

    @Column
    private String level;

    @Column
    private String releasedArea;

    @Column
    private Integer basementArea;

    @Column
    private Integer emptyArea;

    @Column
    private String descriptionArea;

    @Column
    private Integer releasedCost;

    @Column
    private String descriptionCost;

    @Column
    private Integer feeService;

    @Column
    private Integer feeCar;

    @Column
    private Integer feeMotor;

    @Column
    private Integer feeOvertime;

    @Column
    private Integer feeElectric;

    @Column
    private String depositAmount;

    @Column
    private String paymentAmount;

    @Column
    private String releasedPeriod;

    @Column
    private String decoratedPeriod;

    @Column
    private String managerName;

    @Column
    private String phoneNumber;

    @Column
    private Integer feeBrokerRage;

    @Column
    private String type;

    @Column
    private String image;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "building_staff",
            joinColumns = @JoinColumn(name = "building_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staff_id", nullable = false))
    private List<UserEntity> staffs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
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

    public String getReleasedArea() {
        return releasedArea;
    }

    public void setReleasedArea(String releasedArea) {
        this.releasedArea = releasedArea;
    }

    public Integer getBasementArea() {
        return basementArea;
    }

    public void setBasementArea(Integer basementArea) {
        this.basementArea = basementArea;
    }

    public Integer getEmptyArea() {
        return emptyArea;
    }

    public void setEmptyArea(Integer emptyArea) {
        this.emptyArea = emptyArea;
    }

    public String getDescriptionArea() {
        return descriptionArea;
    }

    public void setDescriptionArea(String descriptionArea) {
        this.descriptionArea = descriptionArea;
    }

    public Integer getReleasedCost() {
        return releasedCost;
    }

    public void setReleasedCost(Integer releasedCost) {
        this.releasedCost = releasedCost;
    }

    public String getDescriptionCost() {
        return descriptionCost;
    }

    public void setDescriptionCost(String descriptionCost) {
        this.descriptionCost = descriptionCost;
    }

    public Integer getFeeService() {
        return feeService;
    }

    public void setFeeService(Integer feeService) {
        this.feeService = feeService;
    }

    public Integer getFeeCar() {
        return feeCar;
    }

    public void setFeeCar(Integer feeCar) {
        this.feeCar = feeCar;
    }

    public Integer getFeeMotor() {
        return feeMotor;
    }

    public void setFeeMotor(Integer feeMotor) {
        this.feeMotor = feeMotor;
    }

    public Integer getFeeOvertime() {
        return feeOvertime;
    }

    public void setFeeOvertime(Integer feeOvertime) {
        this.feeOvertime = feeOvertime;
    }

    public Integer getFeeElectric() {
        return feeElectric;
    }

    public void setFeeElectric(Integer feeElectric) {
        this.feeElectric = feeElectric;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getReleasedPeriod() {
        return releasedPeriod;
    }

    public void setReleasedPeriod(String releasedPeriod) {
        this.releasedPeriod = releasedPeriod;
    }

    public String getDecoratedPeriod() {
        return decoratedPeriod;
    }

    public void setDecoratedPeriod(String decoratedPeriod) {
        this.decoratedPeriod = decoratedPeriod;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getFeeBrokerRage() {
        return feeBrokerRage;
    }

    public void setFeeBrokerRage(Integer feeBrokerRage) {
        this.feeBrokerRage = feeBrokerRage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<UserEntity> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<UserEntity> staffs) {
        this.staffs = staffs;
    }
}
