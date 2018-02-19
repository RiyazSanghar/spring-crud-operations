package com.jpa.entity;



import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private  int id;

    private String email;

    private String password;

    private String name;

    private String lastName;


    private int active;


    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(int id, String email, String password, String name, String lastName, int active, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.active = active;
        this.roles = roles;
    }

    public User(User user)
    {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.active = user.getActive();
        this.roles =user.getRoles();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
