package com.example.dto;


public class BuildingDTO extends AbstractDTO<BuildingDTO>{

    private String buildingName;

    private Integer district;

    private String ward;

    private String street;

    private String structure;

    private Integer basementNumber;

    private String direction;

    private String level;

    private String releasedArea;

    private Integer basementArea;

    private Integer emptyArea;

    private String descriptionArea;

    private Integer releasedCost;

    private String descriptionCost;

    private Integer feeService;

    private Integer feeCar;

    private Integer feeMotor;

    private Integer feeOvertime;

    private Integer feeElectric;

    private String depositAmount;

    private String paymentAmount;

    private String releasedPeriod;

    private String decoratedPeriod;

    private String managerName;

    private String phoneNumber;

    private Integer feeBrokerRage;

    private String[] productType = new String[]{};

    private String image;

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

    public String[] getProductType() {
        return productType;
    }

    public void setProductType(String[] productType) {
        this.productType = productType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
