package com.example.demo.service;

import com.example.demo.model.BookingModel;
import com.example.demo.model.RequestModel.ResponseResult;
import com.example.demo.repo.BookingCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingCrud bookingCrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<List<BookingModel>> BookedPropertyList()
    {
        try
        {
            List<BookingModel> model= bookingCrud.findAll();
            responseResult = new ResponseResult(true,"All Booked Property");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ResponseResult> SaveBooking(BookingModel bookingModel)
    {
        try{
            bookingCrud.save(bookingModel);
            responseResult = new ResponseResult(true,"This Property Booked Successfully!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,"Not Booked,Try Again!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> DeleteByBookingID(int bookingId)
    {
        if(bookingCrud.findById(bookingId).isPresent())
        {
            bookingCrud.deleteById(bookingId);
            responseResult = new ResponseResult(true,"Your Booking of Property is deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"Not exist, This Booking,Please Try again!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

}
