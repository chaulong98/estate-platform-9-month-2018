package com.estate.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String level;

    @Column
    private String leasedArea;

    @Column
    private String descriptionArea;

    @Column
    private Integer rentCost;

    @Column
    private String descriptionCost;

    @Column
    private String feesService;

    @Column
    private String feesCar;

    @Column
    private String feesMotorcycle;

    @Column
    private String feesOvertime;

    @Column
    private String electricBill;

    @Column
    private String deposits;

    @Column
    private String pay;

    @Column
    private String rentTime;

    @Column
    private String decorateTime;

    @Column
    private String managerName;

    @Column
    private String phoneNumber;

    @Column
    private String brokeragefees;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_building",
            joinColumns = @JoinColumn(name = "building_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<UserEntity> staffs = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "priority",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "building_id", nullable = false))
    private List<UserEntity> users = new ArrayList<>();

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

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public List<UserEntity> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<UserEntity> staffs) {
        this.staffs = staffs;
    }
}
