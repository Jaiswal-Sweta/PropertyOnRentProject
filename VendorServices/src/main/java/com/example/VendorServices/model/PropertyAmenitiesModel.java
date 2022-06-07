package com.example.VendorServices.model;

import lombok.Data;
import javax.persistence.*;

@Embeddable
@Data
public class PropertyAmenitiesModel {

    @Column(name="propertyAmenitiesId",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int propertyAmenitiesId;

    @ManyToOne
    @JoinColumn(name = "subamenitiesId")
    private SubAmenitiesModel subAmenities;

}
