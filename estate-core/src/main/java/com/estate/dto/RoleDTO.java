package com.estate.dto;

public class RoleDTO extends AbtractDTO {
	private static final long serialVersionUID = -1789097717724816237L;

	private String name;
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
