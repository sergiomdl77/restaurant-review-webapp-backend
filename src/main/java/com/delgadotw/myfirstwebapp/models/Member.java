package com.delgadotw.myfirstwebapp.models;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER")
public class Member
{
    @Id
    @Column(name = "M_ID")
    private String id;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BIRTHDATE")
    private java.sql.Date birthDate;
    @Column(name = "LOC_STATE")
    private String locState;
    @Column(name = "LOC_ZIP_CODE")
    private String locZipCode;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "EMAIL")
    private String email;


    public Member(String id, String password, String firstName, String lastName, String birthDate, String locState, String locZipCode, String gender, String email) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = java.sql.Date.valueOf(birthDate);
        this.locState = locState;
        this.locZipCode = locZipCode;
        this.gender = gender;
        this.email = email;
    }

    public Member() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = java.sql.Date.valueOf(birthDate);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocState() {
        return locState;
    }

    public void setLocState(String locState) {
        this.locState = locState;
    }

    public String getLocZipCode() {
        return locZipCode;
    }

    public void setLocZipCode(String locZipCode) {
        this.locZipCode = locZipCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
