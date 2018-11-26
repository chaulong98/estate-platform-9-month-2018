package com.estate.dto;

import com.estate.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class BuildingDTO extends AbstractDTO {

    private static final long serialVersionUID = 4428522696190004907L;

    private String productName;

    private String district;

    private String ward;

    private String street;

    private String structure;

    private Integer basementNumber;

    private Integer buildingArea;

    private String direction;

    private String level;

    private String leasedArea;

    private String descriptionArea;

    private Integer rentCost;

    private String descriptionCost;

    private String feesService;

    private String feesCar;

    private String feesMotorcycle;

    private String feesOvertime;

    private String electricBill;

    private String deposits;

    private String pay;

    private String rentTime;

    private String decorateTime;

    private String managerName;

    private String phoneNumber;

    private String brokeragefees;

    private String[] typeBuilding = new String[]{};

    private String note;

    private String link;

    private String map;

    private String image;

    private String base64Image;

    private String imageName;

    private String[] users = new String[]{};

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getLeasedArea() {
        return leasedArea;
    }

    public void setLeasedArea(String leasedArea) {
        this.leasedArea = leasedArea;
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

    public String getFeesService() {
        return feesService;
    }

    public void setFeesService(String feesService) {
        this.feesService = feesService;
    }

    public String getFeesCar() {
        return feesCar;
    }

    public void setFeesCar(String feesCar) {
        this.feesCar = feesCar;
    }

    public String getFeesMotorcycle() {
        return feesMotorcycle;
    }

    public void setFeesMotorcycle(String feesMotorcycle) {
        this.feesMotorcycle = feesMotorcycle;
    }

    public String getFeesOvertime() {
        return feesOvertime;
    }

    public void setFeesOvertime(String feesOvertime) {
        this.feesOvertime = feesOvertime;
    }

    public String getElectricBill() {
        return electricBill;
    }

    public void setElectricBill(String electricBill) {
        this.electricBill = electricBill;
    }

    public String getDeposits() {
        return deposits;
    }

    public void setDeposits(String deposits) {
        this.deposits = deposits;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBrokeragefees() {
        return brokeragefees;
    }

    public void setBrokeragefees(String brokeragefees) {
        this.brokeragefees = brokeragefees;
    }

    public String[] getTypeBuilding() {
        return typeBuilding;
    }

    public void setTypeBuilding(String[] typeBuilding) {
        this.typeBuilding = typeBuilding;
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

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBase64Image() {
        if (base64Image != null){
            return base64Image.split(",")[1];
        }
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

}
