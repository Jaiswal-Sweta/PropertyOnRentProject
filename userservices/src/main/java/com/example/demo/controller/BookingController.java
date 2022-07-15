package com.example.demo.controller;

import com.example.demo.model.BookingModel;
import com.example.demo.model.RequestModel.ResponseResult;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/getall")
    public ResponseEntity<List<BookingModel>> GetAllBookingList()
    {
        return bookingService.BookedPropertyList();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<BookingModel>> getBookingList(@PathVariable int id)
    {
        return bookingService.BookedPropertyListSpecific(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseResult> SaveBooking(@RequestBody BookingModel bookingModel)
    {
        return bookingService.SaveBooking(bookingModel);
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<ResponseResult> DeleteBooking(@PathVariable int bookingId)
    {
        return bookingService.DeleteByBookingID(bookingId);
    }
}
