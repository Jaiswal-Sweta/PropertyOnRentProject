package com.example.VendorServices.service;

import com.example.VendorServices.model.BookingModel;
import com.example.VendorServices.model.PropertyModel;
import com.example.VendorServices.model.RequestModel.ResponseResult;
import com.example.VendorServices.repo.BookingCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingCrud bookingCrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<List<BookingModel>> FindBookedList(int registrationId)
    {
        try
        {
            List<BookingModel> model= bookingCrud.findBookedList(registrationId);
            responseResult = new ResponseResult(true,"All Booked list of All Properties");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

}
