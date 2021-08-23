package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import com.example.demo.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> show() {
        return teamRepository.findAll();
    }

    public Team create(TeamRequest teamRequest) {
        if (teamRepository.count() >= 10) {
            throw new BadRequestException("Impossible to create more than 10 teams");
        }
        boolean condition = true;
        String msg = "";
        Team created = new Team();
        created.setTeam(teamRequest.getTeam());
        for (Team team : teamRepository.findAll()) {
            if (Objects.equals(team.getTeam(), created.getTeam())) {
                condition = false;
                msg = "There's already a team with this name";
            }
        }
        if (condition) return teamRepository.save(created);
        throw new BadRequestException(msg);
    }

    private Team validTeam(Integer number) {
        return teamRepository.findById(number).orElseThrow(() -> new NotFoundException("There's no team with this id"));
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
