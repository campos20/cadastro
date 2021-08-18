package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    private List<Team> teams = new ArrayList<>();

    public List<Team> show() {
        return teamRepository.findAll();
    }

    public Team create(Team team) {
        Team created = new Team();
        created.setTeam(team.getTeam());
        return teamRepository.save(created);
    }

}
