package com.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;

    private String role;

    public Role() {
    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
