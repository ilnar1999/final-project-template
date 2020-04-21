package com.epam.rd.izh.service;

import com.epam.rd.izh.dto.CreatedCar;
import com.epam.rd.izh.entity.Car;
import org.springframework.stereotype.Service;

@Service
public class CarServiceMapper {

    public Car mapCreatedCarToCar(CreatedCar car) {

        return new Car()
                .brand(car.getBrand())
                .model(car.getModel())
                .price(car.getPrice())
                .categoryId(car.getCategoryId())
                .image(car.getImage());
    }

}
