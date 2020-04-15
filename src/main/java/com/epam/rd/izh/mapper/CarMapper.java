package com.epam.rd.izh.mapper;

import com.epam.rd.izh.entity.Car;
import com.epam.rd.izh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CarMapper implements RowMapper<Car> {

    @Autowired
    CategoryService categoryService;

    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Car()
                .id(resultSet.getLong("id"))
                .brand(resultSet.getString("brand"))
                .model(resultSet.getString("model"))
                .price(resultSet.getBigDecimal("price"))
                .category(categoryService.getCategoryById(resultSet.getLong("category_id")))
                .image(resultSet.getBytes("image"));
    }
}
