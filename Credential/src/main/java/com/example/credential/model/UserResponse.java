package com.example.credential.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private String token;
    private String emailId;
    private String role;
}
