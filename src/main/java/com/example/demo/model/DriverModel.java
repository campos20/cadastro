package com.example.demo.model;

public class DriverModel {
    String name;
    Integer number;
    String country;
    String team;

    public DriverModel(String name, Integer number, String country) {
        this.name = name;
        this.number = number;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "DriverModel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", country='" + country + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
