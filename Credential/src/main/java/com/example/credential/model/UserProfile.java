package com.example.credential.model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class UserProfile {
    private String firstName;
    private String lastName;
    private String emailId;
    private String contactNumber;
    private int pincode;
    private String cityName;
    private String stateName;
    private int registrationId;
}
