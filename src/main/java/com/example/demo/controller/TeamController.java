package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.request.TeamRequest;
import com.example.demo.service.TeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    @ApiOperation(value = "Exibe a lista com todas as equipes")
    public List<Team> show() {
        return teamService.show();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria uma nova equipe")
    public Team create(@RequestBody TeamRequest teamRequest) {
        return teamService.create(teamRequest);
    }

}
