package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DriverModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DriverService {

    private static List<DriverModel> drivers = new ArrayList<>();

    static {
        DriverModel d1 = new DriverModel("Max Verstappen", 33, "Netherlands");
        DriverModel d2 = new DriverModel("Lewis Hamilton", 44, "United Kingdom");

        drivers.add(d1);
        drivers.add(d2);
    }

    /*public DriverModel create(String name, Integer number, String country) {
        DriverModel created = new DriverModel(name, number, country);
        drivers.add(created);
        return created;
    }*/

    public List<DriverModel> show() {
        return drivers;
    }

    public DriverModel show(Integer number) {
        for (DriverModel driver : drivers) {
            if (Objects.equals(driver.getNumber(), number)) {
                return driver;
            }
        }
        throw new NotFoundException();
    }

    public String setTeam(Integer number, String team) {
        String msg = "Piloto não encontrado";
        for (DriverModel driver : drivers) {
            if (Objects.equals(driver.getNumber(), number)) {
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
