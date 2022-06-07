package com.example.VendorServices.model;

import lombok.Data;
import javax.persistence.*;
@Embeddable
@Data
public class PhotoModel {

    @Column(name="photoId",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int photoId;
    private String photopath;
}