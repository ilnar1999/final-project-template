package com.epam.rd.izh.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Category {

    private Long id;
    private String name;
    private Set<Car> cars;

    public Category id(Long id) {
        this.setId(id);
        return this;
    }

    public Category name(String name) {
        this.setName(name);
        return this;
    }

    public Category cars(Set<Car> cars) {
        this.cars = cars;
        return this;
    }
}
