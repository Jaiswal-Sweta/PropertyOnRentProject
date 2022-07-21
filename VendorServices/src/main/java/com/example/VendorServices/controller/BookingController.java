package com.example.VendorServices.controller;

import com.example.VendorServices.model.BookingModel;
import com.example.VendorServices.model.PropertyModel;
import com.example.VendorServices.model.RequestModel.ResponseBookingDate;
import com.example.VendorServices.service.BookingService;
import com.example.VendorServices.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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

    @GetMapping("/getbookeddate/{id}")
    public List<ResponseBookingDate> getAllBookingDate(@PathVariable int id)
    {
        return bookingService.FindBookedDate(id);
    }
}
