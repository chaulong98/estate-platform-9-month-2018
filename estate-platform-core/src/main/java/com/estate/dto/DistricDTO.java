package com.estate.dto;

public class DistricDTO extends AbstractDTO {

    private static final long serialVersionUID = 4537876828679648255L;
    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
