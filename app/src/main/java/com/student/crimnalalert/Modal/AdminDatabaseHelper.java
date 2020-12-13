package com.student.crimnalalert.Modal;

public class AdminDatabaseHelper {
    String name,mobilenumber,email,password,govt_id;

    public AdminDatabaseHelper() {
    }

    public AdminDatabaseHelper(String name, String mobilenumber, String email, String password,String govt_id) {
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.password = password;
        this.govt_id = govt_id;
    }

    public String getGovt_id() {
        return govt_id;
    }

    public void setGovt_id(String govt_id) {
        this.govt_id = govt_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
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
}
