package com.estate.entity;


import javax.persistence.*;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    private static final long serialVersionUID = 7835155469471652428L;
    @Column
    private String productName;

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
    private String rank;

    @Column
    private String leasedArea;

    @Column
    private String descriptionArea;

    @Column
    private Integer rentCost;

    @Column
    private String descriptionCost;

    @Column
    private Integer feesService;

    @Column
    private Integer feesCar;

    @Column
    private Integer feesMotorcycle;

    @Column
    private Integer feesOvertime;

    @Column
    private Integer electricBill;

    @Column
    private Integer deposits;

    @Column
    private Integer pay;

    @Column
    private String rentTime;

    @Column
    private String decorateTime;

    @Column
    private String managerName;

    @Column
    private String phoneNumber;

    @Column
    private Integer brokeragefees;

    @Column
    private String type;

    @Column
    private String note;

    @Column
    private String link;

    @Column
    private String map;

    @Column
    private String image;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLeasedArea() {
        return leasedArea;
    }

    public void setLeasedArea(String leasedArea) {
        this.leasedArea = leasedArea;
    }

    public Integer getRentCost() {
        return rentCost;
    }

    public void setRentCost(Integer rentCost) {
        this.rentCost = rentCost;
    }

    public Integer getFeesService() {
        return feesService;
    }

    public void setFeesService(Integer feesService) {
        this.feesService = feesService;
    }

    public Integer getFeesCar() {
        return feesCar;
    }

    public void setFeesCar(Integer feesCar) {
        this.feesCar = feesCar;
    }

    public Integer getFeesMotorcycle() {
        return feesMotorcycle;
    }

    public void setFeesMotorcycle(Integer feesMotorcycle) {
        this.feesMotorcycle = feesMotorcycle;
    }

    public Integer getFeesOvertime() {
        return feesOvertime;
    }

    public void setFeesOvertime(Integer feesOvertime) {
        this.feesOvertime = feesOvertime;
    }

    public Integer getElectricBill() {
        return electricBill;
    }

    public void setElectricBill(Integer electricBill) {
        this.electricBill = electricBill;
    }

    public Integer getDeposits() {
        return deposits;
    }

    public void setDeposits(Integer deposits) {
        this.deposits = deposits;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
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

    public Integer getBrokeragefees() {
        return brokeragefees;
    }

    public void setBrokeragefees(Integer brokeragefees) {
        this.brokeragefees = brokeragefees;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescriptionArea() {
        return descriptionArea;
    }

    public void setDescriptionArea(String descriptionArea) {
        this.descriptionArea = descriptionArea;
    }

    public String getDescriptionCost() {
        return descriptionCost;
    }

    public void setDescriptionCost(String descriptionCost) {
        this.descriptionCost = descriptionCost;
    }
}
