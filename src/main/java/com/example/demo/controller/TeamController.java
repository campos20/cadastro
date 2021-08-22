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
    @ApiOperation(value = "Show the list with all teams")
    public List<Team> show() {
        return teamService.show();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new team")
    public Team create(@RequestBody TeamRequest teamRequest) {
        return teamService.create(teamRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a team, by it's id")
    public void delete(@PathVariable Integer id) {
        teamService.delete(id);
    }

    @PutMapping
    @ApiOperation(value = "Update a team")
    public Team update(@RequestBody Team team) {
        return teamService.update(team);
    }

}
