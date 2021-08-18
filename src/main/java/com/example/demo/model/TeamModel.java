package com.example.demo.model;

import lombok.Data;

@Data
public class TeamModel {
    private String team;

    public TeamModel(String team) {
        this.team = team;
    }

}
