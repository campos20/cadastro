package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import com.example.demo.request.TeamRequest;
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

    public Team create(TeamRequest teamRequest) {
        if (teamRepository.count() >= 10) {
            throw new BadRequestException("Impossible to create more than 10 teams");
        }
        Team created = new Team();
        created.setTeam(teamRequest.getTeam());
        return teamRepository.save(created);
    }

    private Team validTeam(Integer number) {
        Team team = teamRepository.findById(number).orElseThrow(() -> new NotFoundException());
        return team;
    }

    public void delete(Integer number) {
        Team team = validTeam(number);
        teamRepository.delete(team);
    }

    public Team update(Team team) {
        validTeam(team.getId());
        return teamRepository.save(team);
    }
}
