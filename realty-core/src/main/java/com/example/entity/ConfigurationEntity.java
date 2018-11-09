package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "configuration")
public class ConfigurationEntity extends BaseEntity {

	
	private static final long serialVersionUID = -2572502739533524996L;
	
	@Column
	private String typeconfiguration;

	@Column
	private String nameconfiguration;

	@Column
	private String codeconfiguration;

	@Column
	private String valueconfiguration;

	public String getTypeconfiguration() {
		return typeconfiguration;
	}

	public void setTypeconfiguration(String typeconfiguration) {
		this.typeconfiguration = typeconfiguration;
	}

	public String getNameconfiguration() {
		return nameconfiguration;
	}

	public void setNameconfiguration(String nameconfiguration) {
		this.nameconfiguration = nameconfiguration;
	}

	public String getCodeconfiguration() {
		return codeconfiguration;
	}

	public void setCodeconfiguration(String codeconfiguration) {
		this.codeconfiguration = codeconfiguration;
	}

	public String getValueconfiguration() {
		return valueconfiguration;
	}

	public void setValueconfiguration(String valueconfiguration) {
		this.valueconfiguration = valueconfiguration;
	}

	
	
	

}
