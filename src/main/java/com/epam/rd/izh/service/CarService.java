package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.Car;
import com.epam.rd.izh.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public boolean saveCar(Car car) {
        if (carRepository.getCarByBrandAndModel((car.getBrand()), car.getModel()) != null) {
            return false;
        }
        return carRepository.saveCar(car);
    }

    public List<Car> getAllCarsByCategoryId(Long categoryId) {
        return carRepository.getAllCarsByCategoryId(categoryId);
    }

    public boolean deleteCarById(Long id) {
        return carRepository.deleteCarById(id);
    }
}
