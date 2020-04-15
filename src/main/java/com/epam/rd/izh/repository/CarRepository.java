package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class CarRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Set<Car> getAllCarsByCategoryId(Long id) { // TODO
        return null;
    }
}
