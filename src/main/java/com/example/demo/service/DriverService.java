package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;
import com.example.demo.request.DriverRequest;
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

    public Driver create(DriverRequest driverRequest) {
        if (driverRepository.count() >= 20) {
            throw new BadRequestException("Não é possível cadastrar mais do que 20 pilotos");
        }
        Driver created = new Driver();
        created.setName(driverRequest.getName());
        created.setCountry(driverRequest.getCountry());
        created.setNum(driverRequest.getNum());
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
