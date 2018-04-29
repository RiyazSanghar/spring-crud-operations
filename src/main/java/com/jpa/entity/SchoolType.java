package com.jpa.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SCHOOL_TYPE")
public class SchoolType {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 50)
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
