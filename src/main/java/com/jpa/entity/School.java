package com.jpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SCHOOL")
public class School {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(name = "name")
    private String businessName;

    @NotNull
    @Column(nullable = false)
    private boolean activated = false;

    @Size(max = 512)
    @Column(name = "image_url")
    private String imageUrl;


    @JsonIgnore
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> userSet = new HashSet<>();

    @OneToOne
    private SchoolType schoolType;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<User> getuserSet() {
        return userSet;
    }

    public void setuserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
