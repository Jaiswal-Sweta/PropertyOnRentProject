package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registrationdetail")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationId;
    private String firstname;
    private String lastname;
    private String emailId;
    private String password;
    private String contactNumber;

    @Column(length = 6)
    private int pincode;

    @OneToOne
    @JoinColumn(name = "roleId",referencedColumnName = "roleId")
    private RoleModel roleModel;


    @OneToOne
    @JoinColumn(name = "cityId",referencedColumnName = "cityId")
    private CityModel cityModel;
}
