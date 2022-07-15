package com.example.VendorServices.controller;

import com.example.VendorServices.model.BookingModel;
import com.example.VendorServices.model.PropertyModel;
import com.example.VendorServices.service.BookingService;
import com.example.VendorServices.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viewbooking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/getall/{id}")
    public ResponseEntity<List<BookingModel>> getAllBookingList(@PathVariable int id)
    {
        System.out.println("Id :"+id);
        return bookingService.FindBookedList(id);
    }
}
