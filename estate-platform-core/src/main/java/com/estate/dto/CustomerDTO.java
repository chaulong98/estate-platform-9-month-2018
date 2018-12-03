package com.estate.dto;

public class CustomerDTO extends AbstractDTO<CustomerDTO> {

    private static final long serialVersionUID = -1478261594752770476L;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String companyName;

    private String exigenxy;

    private boolean status;

    private String note;

    private Long[] staffs;

    public Long[] getStaffs() {
        return staffs;
    }

    public void setStaffs(Long[] staffs) {
        this.staffs = staffs;
    }



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

}
