package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.Car;
import com.epam.rd.izh.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public Set<Car> getAllCarsByCategoryId(Long id) { // TODO
        return null;
    }
}
