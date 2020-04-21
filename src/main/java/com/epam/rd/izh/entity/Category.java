package com.epam.rd.izh.entity;

import lombok.Data;

import java.util.Collection;
import java.util.HashSet;
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

    public Category cars(Collection<Car> cars) {
        this.cars = new HashSet<>(cars);
        return this;
    }
}
