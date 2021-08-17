package com.example.demo.controller;

import com.example.demo.model.DriverModel;
import com.example.demo.service.DriverService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers")
    @ApiOperation(value = "Exibe a lista completa de pilotos")
    public List<DriverModel> show() {
        return driverService.show();
    }

    @GetMapping("/drivers/{number}")
    @ApiOperation(value = "Exibe informações de um piloto específico, pelo seu número")
    public DriverModel show(@PathVariable Integer number) {
        return driverService.show(number);
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria um novo piloto")
    public DriverModel create(@ApiParam("Nome") @RequestBody @NotBlank String name,
                              @ApiParam("Número") @RequestBody @NotBlank Integer number,
                              @ApiParam("Nacionalidade") @RequestBody @NotBlank String country) {
        return driverService.create(name, number, country);
    }*/

    @PutMapping("/drivers/{number}/set-team")
    @ApiOperation(value = "Adiciona equipe ao piloto especificado")
    public String setTeam(@PathVariable Integer number, String team) {
        return driverService.setTeam(number, team);
    }
}
