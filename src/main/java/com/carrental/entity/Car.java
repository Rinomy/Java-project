package com.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("cars")
public class Car {
    @Id
    @Column("car_id")
    private Long id;
    @Column("make")
    private String company;
    private String model;
    private Integer year;
    private String color;
    private String licensePlate;
    private Double rentalPricePerDay;
    private Boolean isAvailable;
    private LocalDateTime createdAt;
}
