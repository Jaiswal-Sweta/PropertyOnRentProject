package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "property")
public class PropertyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;
    private String propertyName;
    private String address;
    private int pincode;
    private float area;
    private float price;
    private String description;
    private String policy;
    private Date postedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "registrationId")
    private RegistrationModel registrationModel;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propertytypeId")
    private PropertyTypeModel propertyTypeModel;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityId")
    private CityModel cityModel;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "propertyAmenities",joinColumns = @JoinColumn(name = "propertyId"))
    private Set<PropertyAmenitiesModel> propertyAmenitiesModels= new HashSet<PropertyAmenitiesModel>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "photo",joinColumns = @JoinColumn(name = "propertyId"))
    private Set<PhotoModel> photoModel = new HashSet<PhotoModel>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "eventPackages",joinColumns = @JoinColumn(name = "propertyId"))
    private Set<EventPackagesModel> eventPackagesModels= new HashSet<EventPackagesModel>();

}
