package com.jpa.entity;



public class JwtUser {


    private String role;


    private Long id;

    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

}
