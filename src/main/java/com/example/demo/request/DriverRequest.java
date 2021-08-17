package com.example.demo.request;

public class DriverRequest {
    String name;
    Integer number;
    String country;

    public DriverRequest(String name, Integer number, String country) {
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
}
