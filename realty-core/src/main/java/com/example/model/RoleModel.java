package com.example.model;

public class RoleModel extends AbstractModel<RoleModel> {
	
	private static final long serialVersionUID = -3274233698008694565L;
	
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
