package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DriverService {

    private List<Driver> drivers = new ArrayList<>();

    @Autowired
    private DriverRepository driverRepository;

    public Driver create(Driver driver) {
        Driver created = new Driver();
        created.setName(driver.getName());
        created.setCountry(driver.getCountry());
        created.setNum(driver.getNum());
        return driverRepository.save(created);
    }

    public List<Driver> show() {
        return driverRepository.findAll();
    }

    public Driver show(Integer number) {
        return driverRepository.findById(number).orElseThrow(()-> new NotFoundException());
    }

    public String setTeam(Integer number, String team) {
        String msg = "Piloto não encontrado";
        for (Driver driver : drivers) {
            if (Objects.equals(driver.getNum(), number)) {
                if (Objects.equals(driver.getTeam(), null)) {
                    driver.setTeam(team);
                    msg = "Equipe " + team + " adicionada com sucesso ao piloto " + driver.getName();
                }
                else msg = "Piloto já possui equipe";
            }
        }
        return msg;
    }

}
