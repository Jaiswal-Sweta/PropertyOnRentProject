package com.example.adminservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registrationdetail")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private int registration_id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String emailid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contactnumber;

    @Column(length = 6)
    private int pincode;

    @OneToOne
    @JoinColumn(name = "role_id",referencedColumnName = "role_id",nullable = false)
    private RoleModel roleModel;


    @OneToOne
    @JoinColumn(name = "city_id",referencedColumnName = "city_id",nullable = false)
    private CityModel cityModel;
}
