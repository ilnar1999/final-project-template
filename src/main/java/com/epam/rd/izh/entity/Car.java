package com.epam.rd.izh.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String brand;
    @Column(length = 30)
    private String model;
    private BigDecimal price;
    @ManyToOne
    private Category category;
}
