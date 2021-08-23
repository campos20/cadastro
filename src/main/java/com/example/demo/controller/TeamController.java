package com.example.demo.controller;

import com.example.demo.model.Team;
import com.example.demo.request.TeamRequest;
import com.example.demo.service.TeamService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    @ApiOperation(value = "Show the paged list with all teams")
    public Page<Team> findAll(@ApiParam("Page number") @RequestParam(defaultValue = "0") @Min(0) Integer page,
                              @ApiParam("Page size") @RequestParam(defaultValue = "5") @Min(1) @Max(10) Integer size) {
        return teamService.findAll(page, size);
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
