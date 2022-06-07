package com.example.adminservices.model;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Data
@Service
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
