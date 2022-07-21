package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "booking")
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bookingId",nullable = false)
    private int bookingId;

    @Column(nullable = false)
    private Date checkIn;

    @Column(nullable = false)
    private Date checkOut;

    @Column(nullable = false)
    private Float Price;

    @OneToOne
    @JoinColumn(name = "propertyId")
    private PropertyModel propertyModel;

    @OneToOne
    @JoinColumn(name = "userRegistrationId")
    private RegistrationModel registrationModel;

    private int eventPackageId;

    private boolean isActive;
}
