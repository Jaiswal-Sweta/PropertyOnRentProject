package com.example.userservice.model;

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
    @JoinColumn(name = "state_id", referencedColumnName = "stateId")
    private StateModel stateModel;
}
