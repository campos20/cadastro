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
            throw new BadRequestException("Impossible to create more than 20 drivers");
        }
        Driver created = new Driver();
        created.setName(driverRequest.getName());
        created.setCountry(driverRequest.getCountry());
        created.setNum(driverRequest.getNum());
        return driverRepository.save(created);
    }

    public Driver update(Driver driver) {
        validDriver(driver.getId());
        return driverRepository.save(driver);
    }

    public List<Driver> show() {
        return driverRepository.findAll();
    }

    public Driver show(Integer number) {
        /*for (Driver driver : drivers) {
            if (Objects.equals(driver.getNum(), number)) {
                return driver;
            }
        }*/
        return driverRepository.findById(number).orElseThrow(()-> new NotFoundException());
    }

    private Driver validDriver(Integer number) {
        Driver driver = driverRepository.findById(number).orElseThrow(() -> new NotFoundException());
        return driver;
    }

    public void delete(Integer number) {
        Driver driver = validDriver(number);
        driverRepository.delete(driver);
    }

}
