package com.example.algovisualizerbackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class User {
    public User() {}

    public User(Long id,String name,String email){
        this.id=id;
        this.name=name;
        this.email = email;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
