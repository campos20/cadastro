package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.TeamModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TeamService {

    private List<TeamModel> teams = new ArrayList<>();

    public List<TeamModel> show() {
        return teams;
    }

    public TeamModel create(TeamModel teamModel) {
        if (teams.size() < 10) {
            TeamModel created = new TeamModel(teamModel.getTeam());
            for (TeamModel team : teams) {
                if (Objects.equals(team.getTeam(), teamModel.getTeam())) {
                    throw new NotFoundException();
                }
            }
            teams.add(created);
            return created;
        }
        throw new NotFoundException();
    }

}
