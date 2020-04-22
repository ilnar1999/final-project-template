package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Car;
import com.epam.rd.izh.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    CarMapper carMapper;

    public boolean saveCar(Car car) {
        return jdbcTemplate.update(
                "INSERT INTO t_cars(brand, model, price, category_id, image) VALUES(?, ?, ?, ?, ?)",
                car.getBrand(),
                car.getModel(),
                car.getPrice(),
                car.getCategoryId(),
                car.getImage()
        ) > 0;
    }

    public Car getCarByBrandAndModel(String brand, String model) {
        List<Car> cars = jdbcTemplate.query(
                "SELECT * FROM t_cars WHERE brand = ? AND model = ? LIMIT 1",
                carMapper,
                brand,
                model
        );
        if (cars.isEmpty()) {
            return null;
        }
        return cars.get(0);
    }

    public List<Car> getAllCarsByCategoryId(Long categoryId) {
        return jdbcTemplate.query("SELECT * FROM t_cars WHERE category_id = ?", carMapper, categoryId);
    }

    public boolean deleteCarById(Long id) {
        return jdbcTemplate.update("DELETE FROM t_cars WHERE id = ?", id) > 0;
    }
}
