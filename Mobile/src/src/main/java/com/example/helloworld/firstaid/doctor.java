package com.example.helloworld.firstaid;

/**
 * Created by Tanvir Hemel on 11-Apr-17.
 */

public class doctor {
    String id,name,designation,phone;

    public doctor(String id, String name, String designation, String phone) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
