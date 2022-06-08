package com.example.userservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "propertytype")
public class ProepertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertytypeId;

    private String propertytypeName;

}
