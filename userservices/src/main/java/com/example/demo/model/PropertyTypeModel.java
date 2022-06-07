package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Propertytype")
public class PropertyTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertytypeId;
    private String propertytypeName;
}
