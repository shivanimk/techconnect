package com.congressional.techconnect.seniorinfo;

import jakarta.persistence.*;

@Entity
@Table
public class SeniorInfo {
    @Id
    @SequenceGenerator(name = "SeniorInfo_sequence",
            sequenceName = "SeniorInfo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "SeniorInfo_sequence"
    )
    private Long id;
    private String type; //individual or seniorhome
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String passwd;

    public SeniorInfo() {
    }

    public SeniorInfo(String type, String name, String street, String city, String state, String zip, String email, String passwd) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.passwd = passwd;
        this.type = type;
    }

    public SeniorInfo(Long id, String type, String name, String street, String city, String state, String zip, String email, String passwd) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.passwd = passwd;
        this.type = type;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "SeniorInfo{" +
                "SeniorInfoId=" + id +
                ", Name='" + name + '\'' +
                ", address1='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", coordinatorEmail='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
