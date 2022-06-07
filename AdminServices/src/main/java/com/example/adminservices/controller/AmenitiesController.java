package com.example.adminservices.controller;

import com.example.adminservices.model.AmenitiesModel;
import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.service.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/amenities")
public class AmenitiesController {

    @Autowired
    AmenitiesService amenitiesservice;

    @GetMapping("/get")
    public ResponseEntity<List<AmenitiesModel>> GetAllAmenities()
    {
        return amenitiesservice.FindALlAmenities();
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseResult> SaveAmenities(@RequestBody AmenitiesModel amenitiesModel)
    {
        return amenitiesservice.SaveAmenities(amenitiesModel);
    }

    @PutMapping("/edit/{amenitiesId}")
    public ResponseEntity<ResponseResult> UpdateAmenities(@PathVariable int amenitiesId, @RequestBody AmenitiesModel amenitiesModel)
    {
        return amenitiesservice.UpdateAmenities(amenitiesId,amenitiesModel);
    }

    @DeleteMapping("/delete/{amenitiesId}")
    public ResponseEntity<ResponseResult> DeleteAmenities(@PathVariable int amenitiesId)
    {
        return amenitiesservice.DeleteByIDAmenities(amenitiesId);
    }

}
