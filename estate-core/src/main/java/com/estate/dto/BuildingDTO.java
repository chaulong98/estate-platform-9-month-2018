package com.estate.dto;


public class BuildingDTO extends AbtractDTO {
	private static final long serialVersionUID = 4428522696190004907L;
	private String name;
	private String townShip;
	private String street;
	private String precinct;
	private String composition;
	private Integer numberOfBasement;
	private Integer buildingArea;
	private String rentArea;
	private String descriptionArea;
	private String way;
	private String rank;
	private long price;
	private String descriptionPrice;
	private String serviceFee;
	private String carFee;
	private String motocycleFee;
	private String overtimeFee;
	private String managerName;
	private String managerPhone;
	private String pay;
	private String leaseTerm;
	private String decorationTime;
	private String brokerageFees;
	private String[] typeArrays = new String[]{};
	private String Note;
	private String link;
	private String map;
	private String image;
	private String district;
	private String imageName;
	private String thumbnailBase64;
	private Integer areaFrom;
	private Integer areaTo;
	private Integer costFrom;
	private Integer costTo;
	private String staffName;
	private String address;
	private String areaFree;
	private boolean priority = false;
	private boolean editBuilding = false;
	private String createdByUser;
	private Long staffId;

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

	public String[] getTypeArrays() {
		return typeArrays;
	}

	public void setTypeArrays(String[] typeArrays) {
		this.typeArrays = typeArrays;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getThumbnailBase64() {
		return thumbnailBase64;
	}

	public void setThumbnailBase64(String thumbnailBase64) {
		this.thumbnailBase64 = thumbnailBase64;
	}

	public Integer getAreaFrom() {
		return areaFrom;
	}

	public void setAreaFrom(Integer areaFrom) {
		this.areaFrom = areaFrom;
	}

	public Integer getAreaTo() {
		return areaTo;
	}

	public void setAreaTo(Integer areaTo) {
		this.areaTo = areaTo;
	}

	public Integer getCostFrom() {
		return costFrom;
	}

	public void setCostFrom(Integer costFrom) {
		this.costFrom = costFrom;
	}

	public Integer getCostTo() {
		return costTo;
	}

	public void setCostTo(Integer costTo) {
		this.costTo = costTo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreaFree() {
		return areaFree;
	}

	public void setAreaFree(String areaFree) {
		this.areaFree = areaFree;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public boolean isEditBuilding() {
		return editBuilding;
	}

	public void setEditBuilding(boolean editBuilding) {
		this.editBuilding = editBuilding;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
}
