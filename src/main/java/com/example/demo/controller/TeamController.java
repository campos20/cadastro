package com.example.demo.controller;

import com.example.demo.model.TeamModel;
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
    public List<TeamModel> show() {
        return teamService.show();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria uma nova equipe")
    public TeamModel create(@RequestBody TeamModel teamModel) {
        return teamService.create(teamModel);
    }

}
