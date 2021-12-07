package com.example.organizationservice.model;

import lombok.Data;

@Data
public class Organization {

    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;

    public Organization(String id, String name){
        this.id = id;
        this.name = name;
    }
}
