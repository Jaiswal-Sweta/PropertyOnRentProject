package com.example.adminservices.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class CityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private int city_id;

    @Column(nullable = false)
    private String city_name;

    @ManyToOne
    @JoinColumn(name = "state_id",referencedColumnName = "state_id",nullable = false)
    private StateModel stateModel;
}
