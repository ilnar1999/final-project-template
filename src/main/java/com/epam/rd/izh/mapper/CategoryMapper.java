package com.epam.rd.izh.mapper;

import com.epam.rd.izh.entity.Category;
import com.epam.rd.izh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryMapper implements RowMapper<Category> {

    @Autowired
    CarService carService;

    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        Long id = resultSet.getLong("id");
        return new Category()
                .id(id)
                .name(resultSet.getString("name"))
                .cars(carService.getAllCarsByCategoryId(id));
    }
}
