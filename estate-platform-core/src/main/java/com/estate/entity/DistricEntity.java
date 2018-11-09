package com.estate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "distric")
public class DistricEntity extends BaseEntity{

    private static final long serialVersionUID = -1308336977037166007L;
    @Column
    private String code;

    @Column
    private String name;

    @OneToMany(mappedBy = "districEntity", fetch = FetchType.EAGER)
    private List<BuildingEntity> news = new ArrayList<>();

    public List<BuildingEntity> getNews() {
        return news;
    }

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
