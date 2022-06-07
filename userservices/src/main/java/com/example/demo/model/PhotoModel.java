package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Embeddable
@Data
public class PhotoModel {

    @Column(name="photoId",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int photoId;
    private String photopath;
}