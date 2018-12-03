package com.estate.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity extends BaseEntity {

    private static final long serialVersionUID = -4907767318320601464L;

    @Column
    private String fullName;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String companyName;

    @Column
    private String exigenxy;

    @Column
    private boolean status;

    @Column
    @Type(type = "text")
    private String note;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_customer", joinColumns = {
            @JoinColumn(name = "customer_id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "user_id", nullable = false)})
    private List<UserEntity> staffs = new ArrayList<>();




    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }








    public String getExigenxy() {
        return exigenxy;
    }

    public void setExigenxy(String exigenxy) {
        this.exigenxy = exigenxy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<UserEntity> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<UserEntity> staffs) {
        this.staffs = staffs;
    }
}
