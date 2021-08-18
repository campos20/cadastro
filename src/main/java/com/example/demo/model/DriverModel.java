package com.example.demo.model;

import lombok.Data;

@Data
public class DriverModel {
    private String name;
    private Integer number;
    private String country;
    private String team;

    public DriverModel(String name, Integer number, String country) {
        this.name = name;
        this.number = number;
        this.country = country;
    }
}
