package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DriverModel;
import com.example.demo.request.DriverRequest;
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

    public DriverModel create(DriverRequest driverRequest) {
        if (drivers.size() < 20) {
            DriverModel created = new DriverModel(driverRequest.getName(), driverRequest.getNumber(), driverRequest.getCountry());
            for (DriverModel driver : drivers) {
                if (Objects.equals(driver.getNumber(), driverRequest.getNumber()) ||
                Objects.equals(driver.getName(), driverRequest.getName())) {
                    throw new NotFoundException();
                }
            }
            drivers.add(created);
            return created;
        }
        throw new NotFoundException();
    }

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
