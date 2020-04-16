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

    public List<Car> getAllCarsByCategoryId(Long categoryId) {
        return jdbcTemplate.query("SELECT * FROM t_cars WHERE category_id = ?", carMapper, categoryId);
    }
}
