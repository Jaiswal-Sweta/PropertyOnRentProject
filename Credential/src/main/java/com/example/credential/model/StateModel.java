package com.example.credential.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "state")
public class StateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stateId;
    private String stateName;
}
