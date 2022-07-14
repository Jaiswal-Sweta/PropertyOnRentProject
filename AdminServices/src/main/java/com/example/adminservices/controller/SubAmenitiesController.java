package com.example.adminservices.controller;

import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.model.SubAmenitiesModel;
import com.example.adminservices.service.SubAmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subamenities")
@CrossOrigin(origins = "*")
public class SubAmenitiesController {

    @Autowired
    SubAmenitiesService subAmenitiesService;

    @GetMapping("/get")
    public ResponseEntity<List<SubAmenitiesModel>> GetAllSubAmenities()
    {
        return subAmenitiesService.FindAllSubAmenties();
    }

    @GetMapping("/get/{ID}")
    public ResponseEntity<List<SubAmenitiesModel>> GetSubAmenitieswise(@PathVariable int ID)
    {
        return subAmenitiesService.FindSubAmenitieswise(ID);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseResult> AddSubAmenities(@RequestBody SubAmenitiesModel subAmenitiesModel)
    {
        return subAmenitiesService.SaveSubAmenities(subAmenitiesModel);
    }

    @PutMapping("/edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateSubAmenities(@PathVariable int ID, @RequestBody SubAmenitiesModel subAmenitiesModel)
    {
        return subAmenitiesService.UpdateSubAmenities(ID,subAmenitiesModel);
    }

    @DeleteMapping("delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteSubAmenities(@PathVariable int ID)
    {
        return subAmenitiesService.DeleteByIDSubAmenities(ID);
    }
}
