package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class CityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "stateId",referencedColumnName = "stateId")
    private StateModel stateModel;
}