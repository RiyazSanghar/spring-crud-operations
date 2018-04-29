package com.jpa.controller.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;


public class SchoolSignupDTO {


    @NotNull
    private String schoolName;

    @NotNull
    private String country;

    @NotNull
    private String state;

    @NotNull
    private String city;

    private String Address;

    @Email
    private String email;

    @NotNull
    private Long schoolType;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(Long schoolType) {
        this.schoolType = schoolType;
    }
}
