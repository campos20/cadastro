package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Driver;
import com.example.demo.model.Team;
import com.example.demo.repository.DriverRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.request.DriverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Driver create(DriverRequest driverRequest) {
        if (driverRepository.count() >= 20) {
            throw new BadRequestException("Impossible to create more than 20 drivers");
        }
        if (driverRepository.existsByName(driverRequest.getName())) {
            throw new BadRequestException("There's already a driver with this name");
        }
        if (driverRepository.existsByNum(driverRequest.getNum())) {
            throw new BadRequestException("There's already a driver with this number");
        }
        Driver created = new Driver();
        return driverRepository.save(created);
    }

    public Page<Driver> findAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return driverRepository.findAll(pageRequest);
    }

    public Driver show(Integer number) {
        return validDriver(number);
    }

    private Driver validDriver(Integer number) {
        for (Driver driver : driverRepository.findAll()) {
            if (Objects.equals(driver.getNum(), number)) {
                return driver;
            }
        }
        throw new NotFoundException("There's no driver with this number");
    }

    public void delete(Integer number) {
        Driver driver = validDriver(number);
        driverRepository.delete(driver);
    }

    public Driver setTeam(Integer number, String team) {
        Driver driver = validDriver(number);
        boolean condition = false;
        String msg = "";
        if (driver.getTeam() == null) {
            for (Team team1 : teamRepository.findAll()) {
                if (Objects.equals(team1.getTeam(), team)) {
                    condition = true;
                    driver.setTeam(team);
                    break;
                } else msg = "Team not found";
            }
        }
        else msg = "Driver already has a team";
        if (condition) return driverRepository.save(driver);
        throw new BadRequestException(msg);
    }

}
