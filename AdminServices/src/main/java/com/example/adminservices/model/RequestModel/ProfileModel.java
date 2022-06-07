package com.example.adminservices.model.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProfileModel {

    private int registrationid;
    private String firstname;
    private String lastname;
    private String emailid;
    private String contactnumber;
    private int city_id;
    private String city_name;
    private int state_id;
    private String state_name;
    private int pincode;
}