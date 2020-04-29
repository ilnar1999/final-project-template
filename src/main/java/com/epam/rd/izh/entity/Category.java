package com.epam.rd.izh.entity;

import lombok.Data;

import java.util.*;

@Data
public class Category {

    private Long id;
    private String name;
    private List<Car> cars;

    public Category id(Long id) {
        this.setId(id);
        return this;
    }

    public Category name(String name) {
        this.setName(name);
        return this;
    }

    public Category cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        return this;
    }
}
