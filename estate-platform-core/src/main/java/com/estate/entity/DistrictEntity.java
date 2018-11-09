package com.estate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity{

    private static final long serialVersionUID = -1308336977037166007L;
    @Column
    private String code;

    @Column
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
