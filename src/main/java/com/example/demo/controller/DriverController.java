package com.example.demo.controller;

import com.example.demo.model.Driver;
import com.example.demo.request.DriverRequest;
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
    @ApiOperation(value = "Show the list with all drivers")
    public List<Driver> show() {
        return driverService.show();
    }

    @GetMapping("/{number}")
    @ApiOperation(value = "Show a driver by his number")
    public Driver show(@PathVariable Integer number) {
        return driverService.show(number);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new driver")
    public Driver create(@RequestBody @Valid DriverRequest driverRequest) {
        return driverService.create(driverRequest);
    }

    @DeleteMapping("/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a driver")
    public void delete(@PathVariable Integer number) {
        driverService.delete(number);
    }

    @PutMapping
    @ApiOperation(value = "Adding a team to a driver")
    public Driver setTeam(Integer number, String team) {
        return driverService.setTeam(number, team);
    }

}
