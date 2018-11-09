package com.example.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

	private static final long serialVersionUID = -8178740060328594029L;

	@Column
	private String nameBuilding;
	@Column
	private Date startTime;
	@Column
	private String thumbnail;
	@Column
	private Integer floorArea;
	@Column
	private Double numberBasement;

	@Column
	private String district;

	@Column
	private String guild;

	@Column
	private String street;

	@Column
	private String direction;

	@Column
	private String rate;

	@Column(columnDefinition = "TEXT")
	private String rentArea;

	@Column
	private String descriptionArea;

	@Column
	private Integer costRent;

	@Column
	private String priceDescription;

	@Column
	private String serviceCharge;
	@Column
	private String chargeCar;
	@Column
	private String chargeMoto;
	@Column
	private String ChangeOutTime;
	@Column
	private String electricBill;

	@Column
	private String deposit;

	@Column
	private Double pay;

	@Column
	private String timeout;

	@Column
	private String decorateTime;
	@Column
	private String managementName;
	@Column
	private String managementPhone;
	@Column
	private String productType;
	@Column
	private String note;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_building", joinColumns = {
			@JoinColumn(name = "building_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false) })

	private List<UserEntity> userEntity;

	public List<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(List<UserEntity> userEntity) {
		this.userEntity = userEntity;
	}

	public String getNameBuilding() {
		return nameBuilding;
	}

	public void setNameBuilding(String nameBuilding) {
		this.nameBuilding = nameBuilding;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getGuild() {
		return guild;
	}

	public void setGuild(String guild) {
		this.guild = guild;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
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

	public String getPriceDescription() {
		return priceDescription;
	}

	public void setPriceDescription(String priceDescription) {
		this.priceDescription = priceDescription;
	}

	public String getChangeOutTime() {
		return ChangeOutTime;
	}

	public void setChangeOutTime(String changeOutTime) {
		ChangeOutTime = changeOutTime;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}

	public Double getNumberBasement() {
		return numberBasement;
	}

	public void setNumberBasement(Double numberBasement) {
		this.numberBasement = numberBasement;
	}

	public Integer getCostRent() {
		return costRent;
	}

	public void setCostRent(Integer costRent) {
		this.costRent = costRent;
	}

	public String getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getChargeCar() {
		return chargeCar;
	}

	public void setChargeCar(String chargeCar) {
		this.chargeCar = chargeCar;
	}

	public String getChargeMoto() {
		return chargeMoto;
	}

	public void setChargeMoto(String chargeMoto) {
		this.chargeMoto = chargeMoto;
	}

	public String getElectricBill() {
		return electricBill;
	}

	public void setElectricBill(String electricBill) {
		this.electricBill = electricBill;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getDecorateTime() {
		return decorateTime;
	}

	public void setDecorateTime(String decorateTime) {
		this.decorateTime = decorateTime;
	}

	public String getManagementName() {
		return managementName;
	}

	public void setManagementName(String managementName) {
		this.managementName = managementName;
	}

	public String getManagementPhone() {
		return managementPhone;
	}

	public void setManagementPhone(String managementPhone) {
		this.managementPhone = managementPhone;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
