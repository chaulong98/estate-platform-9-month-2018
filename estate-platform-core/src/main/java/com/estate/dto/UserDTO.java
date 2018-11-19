package com.estate.dto;

import com.estate.entity.BuildingEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractDTO{
    private String userName;
    private String fullName;
    private String password;
    private Integer status;
    private List<BuildingEntity> buildings = new ArrayList<>();
    private String check;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<BuildingEntity> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingEntity> buildings) {
        this.buildings = buildings;
    }
}
