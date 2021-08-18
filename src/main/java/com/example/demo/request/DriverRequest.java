package com.example.demo.request;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class DriverRequest {
    @NotBlank(message = "Driver name cannot be null")
    private String name;
    @Min(0)
    private Integer number;
    @NotBlank(message = "Driver country cannot be null")
    private String country;

    public DriverRequest(String name, Integer number, String country) {
        this.name = name;
        this.number = number;
        this.country = country;
    }

}
