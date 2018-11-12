package com.estate.builder;

public class BuildingBuilder {
	private String district;
	private String province;
	private String street;
	private Integer areaFrom;
	private Integer areaTo;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Integer costFrom;
	private Integer costTo;
	private String[] types = new String[]{};

	public BuildingBuilder(Builder builder) {
		this.district = builder.district;
		this.province = builder.province;
		this.street = builder.street;
		this.areaFrom = builder.areaFrom;
		this.areaTo = builder.areaTo;
		this.numberOfBasement = builder.numberOfBasement;
		this.direction = builder.direction;
		this.level = builder.level;
		this.costFrom = builder.costFrom;
		this.costTo = builder.costTo;
		this.types = builder.types;
	}


	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
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

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}


	public static class Builder {
		private String district;
		private String province;
		private String street;
		private Integer areaFrom;
		private Integer areaTo;
		private Integer numberOfBasement;
		private String direction;
		private String level;
		private Integer costFrom;
		private Integer costTo;
		private String[] types = new String[]{};

		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}
		public Builder setProvince(String province) {
			this.province = province;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public Builder setAreaFrom(Integer areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}

		public Builder setAreaTo(Integer areaTo) {
			this.areaTo = areaTo;
			return this;
		}

		public Builder setDirection(String direction) {
			this.direction = direction;
			return this;
		}

		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}

		public Builder setCostFrom(Integer costFrom) {
			this.costFrom = costFrom;
			return this;
		}

		public Builder setCostTo(Integer costTo) {
			this.costTo = costTo;
			return this;
		}

		public Builder setTypes(String[] types) {
			this.types = types;
			return this;
		}

		public BuildingBuilder build() {
			return new BuildingBuilder(this);
		}

	}
}
