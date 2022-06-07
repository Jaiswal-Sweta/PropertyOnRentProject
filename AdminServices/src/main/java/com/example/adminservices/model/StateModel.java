package com.example.adminservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "state")
public class StateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private int state_id;

    @Column(nullable = false)
    private String state_name;
}
