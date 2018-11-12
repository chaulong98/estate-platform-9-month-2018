package com.estate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

	private static final long serialVersionUID = 4794192783029867405L;

	@Column
	private String name;

	@Column
	private String townShip;

	@Column
	private String street;

	@Column
	private String precinct;

	@Column
	private String composition;

	@Column
	private Integer numberOfBasement;

	@Column
	private Integer buildingArea;

	@Column(columnDefinition = "TEXT")
	private String rentArea;

	@Column
	private String descriptionArea;

	@Column
	private String way;

	@Column
	private String rank;

	@Column
	private long price;

	@Column
	private String descriptionPrice;

	@Column
	private String serviceFee;

	@Column
	private String carFee;

	@Column
	private String motocycleFee;

	@Column
	private String overtimeFee;

	@Column
	private String managerName;

	@Column
	private String managerPhone;

	@Column
	private String pay;

	@Column
	private String leaseTerm;

	@Column
	private String decorationTime;

	@Column
	private String brokerageFees;

	@Column(columnDefinition = "TEXT")
	private String typeProduction;

	@Column(columnDefinition = "TEXT")
	private String Note;

	@Column
	private String link;

	@Column(columnDefinition = "TEXT")
	private String map;

	@Column
	private String image;

	@Column
	private String district;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "assignment", joinColumns = {
			@JoinColumn(name = "building_id", nullable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "user_id", nullable = false)})
	private List<UserEntity> staffs = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "priority", joinColumns = {
			@JoinColumn(name = "building_id", nullable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "user_id", nullable = false)})
	private List<UserEntity> users = new ArrayList<>();

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTownShip() {
		return townShip;
	}

	public void setTownShip(String townShip) {
		this.townShip = townShip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPrecinct() {
		return precinct;
	}

	public void setPrecinct(String precinct) {
		this.precinct = precinct;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Integer getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
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

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDescriptionPrice() {
		return descriptionPrice;
	}

	public void setDescriptionPrice(String descriptionPrice) {
		this.descriptionPrice = descriptionPrice;
	}

	public String getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getCarFee() {
		return carFee;
	}

	public void setCarFee(String carFee) {
		this.carFee = carFee;
	}

	public String getMotocycleFee() {
		return motocycleFee;
	}

	public void setMotocycleFee(String motocycleFee) {
		this.motocycleFee = motocycleFee;
	}

	public String getOvertimeFee() {
		return overtimeFee;
	}

	public void setOvertimeFee(String overtimeFee) {
		this.overtimeFee = overtimeFee;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getLeaseTerm() {
		return leaseTerm;
	}

	public void setLeaseTerm(String leaseTerm) {
		this.leaseTerm = leaseTerm;
	}

	public String getDecorationTime() {
		return decorationTime;
	}

	public void setDecorationTime(String decorationTime) {
		this.decorationTime = decorationTime;
	}

	public String getBrokerageFees() {
		return brokerageFees;
	}

	public void setBrokerageFees(String brokerageFees) {
		this.brokerageFees = brokerageFees;
	}

	public String getTypeProduction() {
		return typeProduction;
	}

	public void setTypeProduction(String typeProduction) {
		this.typeProduction = typeProduction;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
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

	public List<UserEntity> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<UserEntity> staffs) {
		this.staffs = staffs;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}
