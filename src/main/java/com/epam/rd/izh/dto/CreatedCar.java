package com.epam.rd.izh.dto;

import lombok.Data;

@Data
public class CreatedCar {

    private String brand;
    private String model;
    private Long price;
    private Long categoryId;
    private String image;
}
