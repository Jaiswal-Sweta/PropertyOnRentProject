package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "amenities")
public class AmenitiesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="amenitiesId",nullable = false)
    private int amenitiesId;

    @Column(nullable = false)
    private String amenitiesName;
}
