package com.example.credential.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseData {
    private Boolean success;
    private String message;
}
