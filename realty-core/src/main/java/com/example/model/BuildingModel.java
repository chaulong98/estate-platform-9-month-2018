package com.example.model;

import java.util.Date;
import java.util.List;
import java.util.Map;



public class BuildingModel extends AbstractModel<BuildingModel> {


	private static final long serialVersionUID = -3102755265825827766L;
	
	private String imageName;
	
    private String base64Image;
	
	private Long[] dependencies;

	private String nameBuilding;
	// thoi gian bắt đầu

	private Date startTime;

	private String thumbnail;
	// diện tích sàn
	private Integer floorArea;
	// số tầng
	private Double numberBasement;

	// quận
	private String district;

	// phường
	private String guild;

	private String street;

	// hướng
	private String direction;

	// hạng
	private String rate;
	// diện tích thuê( chú ý chỉ dc nhập số và dấu ,)

	private String rentArea;

	// mo ta s
	private String descriptionArea;

	// gia thue
	private Integer costRent;

	// mo ta gia
	private String priceDescription;

	private String serviceCharge;

	private String chargeCar;

	private String chargeMoto;

	private String ChangeOutTime;

	private String electricBill;

	// thang dat coc
	private String deposit;
	//thanh toan

	private Double pay;

	private String timeout;

	private String decorateTime;

	private String managementName;

	private String managementPhone;

	private String productType;

	private String note;

	private String[] productTypeModel;

	private List<UserModel> listuser;

	private Map<String, String> mapDistrict;

	public Long[] getDependencies() {
		return dependencies;
	}

	public void setDependencies(Long[] dependencies) {
		this.dependencies = dependencies;
	}

	public String getNameBuilding() {
		return nameBuilding;
	}

	public void setNameBuilding(String nameBuilding) {
		this.nameBuilding = nameBuilding;
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

	public Integer getCostRent() {
		return costRent;
	}

	public void setCostRent(Integer costRent) {
		this.costRent = costRent;
	}

	public String getPriceDescription() {
		return priceDescription;
	}

	public void setPriceDescription(String priceDescription) {
		this.priceDescription = priceDescription;
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

	public String getChangeOutTime() {
		return ChangeOutTime;
	}

	public void setChangeOutTime(String changeOutTime) {
		ChangeOutTime = changeOutTime;
	}

	public String getElectricBill() {
		return electricBill;
	}

	public void setElectricBill(String electricBill) {
		this.electricBill = electricBill;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String[] getProductTypeModel() {
		return productTypeModel;
	}

	public void setProductTypeModel(String[] productTypeModel) {
		this.productTypeModel = productTypeModel;
	}

	public List<UserModel> getListuser() {
		return listuser;
	}

	public void setListuser(List<UserModel> listuser) {
		this.listuser = listuser;
	}

	public Map<String, String> getMapDistrict() {
		return mapDistrict;
	}

	public void setMapDistrict(Map<String, String> mapDistrict) {
		this.mapDistrict = mapDistrict;
	}


	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getBase64Image() {
//		cắt chuỗi base 64
		if(base64Image != null) {
			return base64Image.split(",")[1];
			
		}
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

}
