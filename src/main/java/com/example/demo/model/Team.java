package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "team")
@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String team;
}
