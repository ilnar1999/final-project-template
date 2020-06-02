package com.epam.rd.izh.mapper;

import com.epam.rd.izh.entity.Car;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CarMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Car()
                .id(resultSet.getLong("id"))
                .brand(resultSet.getString("brand"))
                .model(resultSet.getString("model"))
                .price(resultSet.getLong("price"))
                .categoryId(resultSet.getLong("category_id"))
                .image(resultSet.getString("image"));
    }
}
