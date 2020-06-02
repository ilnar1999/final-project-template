package com.epam.rd.izh.entity;

import lombok.Data;

@Data
public class Car {

    private Long id;
    private String brand;
    private String model;
    private Long price;
    private Long categoryId;
    private String image;

    public Car id(Long id) {
        this.setId(id);
        return this;
    }

    public Car brand(String brand) {
        this.setBrand(brand);
        return this;
    }

    public Car model(String model) {
        this.setModel(model);
        return this;
    }

    public Car price(Long price) {
        this.setPrice(price);
        return this;
    }

    public Car categoryId(Long categoryId) {
        this.setCategoryId(categoryId);
        return this;
    }

    public Car image(String image) {
        this.setImage(image);
        return this;
    }
}
