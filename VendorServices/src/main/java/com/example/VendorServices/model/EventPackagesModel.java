package com.example.VendorServices.model;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class EventPackagesModel {

    @Column(name="eventPackageId",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventPackageId;

    private String packageName;
    private String packageDescription;
    private float Rate;

    @ManyToOne
    @JoinColumn(name = "eventId")
    private EventsModel eventsModel;

}

