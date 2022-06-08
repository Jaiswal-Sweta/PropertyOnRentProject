package com.example.userservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "property")
public class PropertyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private float area;

    @Column(nullable = false)
    private String description;

    private int pincode;

    @Column(nullable = false)
    private String policy;

    @Column(nullable = false)
    private Date postedDate;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String propertyName;

    @ManyToOne
    @JoinColumn(name = "registration_id", referencedColumnName = "registrationId", nullable = false)
    private RegistrationModel registrationModel;

    @ManyToOne
    @JoinColumn(name = "propertytype_id", referencedColumnName = "propertytypeId", nullable = false)
    private ProepertyType proepertyType;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "cityId", nullable = false)
    private CityModel cityModel;
}
