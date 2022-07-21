package com.example.VendorServices.model.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
public class ResponseBookingDate {
    private Date checkIn;
    private Date checkOut;
}