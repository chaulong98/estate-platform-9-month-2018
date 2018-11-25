package com.estate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity {

    private static final long serialVersionUID = 6868402481298352095L;
    @Column
    private String name;

    @Column
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
