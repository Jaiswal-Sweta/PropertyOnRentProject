package com.example.adminservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Propertytype")
public class PropertyTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private int propertytype_id;

    @Column(nullable = false)
    private String propertytype_name;
}
