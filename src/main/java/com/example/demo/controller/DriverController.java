package com.example.demo.controller;

import com.example.demo.model.Driver;
import com.example.demo.service.DriverService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    @ApiOperation(value = "Exibe a lista completa de pilotos")
    public List<Driver> show() {
        return driverService.show();
    }

    @GetMapping("/{number}")
    @ApiOperation(value = "Exibe informações de um piloto específico, pelo seu número")
    public Driver show(@PathVariable Integer number) {
        return driverService.show(number);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria um novo piloto")
    public Driver create(@RequestBody @Valid Driver driver) {
        return driverService.create(driver);
    }

    @PutMapping("{number}/set-team")
    @ApiOperation(value = "Adiciona equipe ao piloto especificado")
    public String setTeam(@PathVariable Integer number, String team) {
        return driverService.setTeam(number, team);
    }
}
