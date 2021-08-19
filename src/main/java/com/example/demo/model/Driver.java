package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "driver")
@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer num;
    private String team;
    private String country;
}
