package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subamenities")
public class SubAmenitiesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private int subamenitiesId;

    @Column(nullable = false)
    private String subamenitiesName;

    @ManyToOne
    @JoinColumn(name = "amenitiesId",referencedColumnName = "amenitiesId",nullable = false)
    private AmenitiesModel amenitiesModel;

}
