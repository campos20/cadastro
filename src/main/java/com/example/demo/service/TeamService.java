package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
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
            throw new BadRequestException("Não é possível cadastrar mais do que 10 equipes");
        }
        Team created = new Team();
        created.setTeam(teamRequest.getTeam());
        return teamRepository.save(created);
    }

}
