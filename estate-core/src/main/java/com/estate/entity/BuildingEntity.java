package com.estate.entity;

import javax.persistence.*;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    private static final long serialVersionUID = 6259666949626374100L;
    @Column
    private String name;

    @Column
    private String district;

    @Column
    private String ward;

    @Column
    private String street;

    @Column
    private String structure;

    @Column
    private String basement;

    @Column
    private String floorarea;

    @Column
    private String direction;

    @Column
    private String grade;

    @Column
    private String rentingarea;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private String rentingfee;

    @Column
    private String feedescription;

    @Column
    private String servicefee;

    @Column
    private String carfee;

    @Column
    private String motorbikefee;

    @Column
    private String outtimefee;

    @Column
    private String electricbill;

    @Column
    private String deposit;

    @Column
    private String paymentmethod;

    @Column
    private String rentingduration;

    @Column
    private String decoratetime;

    @Column
    private String managername;

    @Column
    private String managerphone;

    @Column
    private String agencyfee;

    @Column
    private String buildingform;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column
    private String link;

    @Column
    private String map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBasement() {
        return basement;
    }

    public void setBasement(String basement) {
        this.basement = basement;
    }

    public String getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(String floorarea) {
        this.floorarea = floorarea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRentingarea() {
        return rentingarea;
    }

    public void setRentingarea(String rentingarea) {
        this.rentingarea = rentingarea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRentingfee() {
        return rentingfee;
    }

    public void setRentingfee(String rentingfee) {
        this.rentingfee = rentingfee;
    }

    public String getFeedescription() {
        return feedescription;
    }

    public void setFeedescription(String feedescription) {
        this.feedescription = feedescription;
    }

    public String getServicefee() {
        return servicefee;
    }

    public void setServicefee(String servicefee) {
        this.servicefee = servicefee;
    }

    public String getCarfee() {
        return carfee;
    }

    public void setCarfee(String carfee) {
        this.carfee = carfee;
    }

    public String getMotorbikefee() {
        return motorbikefee;
    }

    public void setMotorbikefee(String motorbikefee) {
        this.motorbikefee = motorbikefee;
    }

    public String getOuttimefee() {
        return outtimefee;
    }

    public void setOuttimefee(String outtimefee) {
        this.outtimefee = outtimefee;
    }

    public String getElectricbill() {
        return electricbill;
    }

    public void setElectricbill(String electricbill) {
        this.electricbill = electricbill;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getRentingduration() {
        return rentingduration;
    }

    public void setRentingduration(String rentingduration) {
        this.rentingduration = rentingduration;
    }

    public String getDecoratetime() {
        return decoratetime;
    }

    public void setDecoratetime(String decoratetime) {
        this.decoratetime = decoratetime;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone;
    }

    public String getAgencyfee() {
        return agencyfee;
    }

    public void setAgencyfee(String agencyfee) {
        this.agencyfee = agencyfee;
    }

    public String getBuildingform() {
        return buildingform;
    }

    public void setBuildingform(String buildingform) {
        this.buildingform = buildingform;
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
}
