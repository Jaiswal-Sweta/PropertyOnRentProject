package com.example.adminservices.controller;

import com.example.adminservices.model.PropertyTypeModel;
import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/propertytype")
public class PropertyTypeController {

    @Autowired
    public PropertyTypeService propertytypeservice;

    @GetMapping("/get")
    public ResponseEntity<List<PropertyTypeModel>> GetAllPropertyType()
    {
        return propertytypeservice.FindAllPropertyType();
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseResult> AddPropertyType(@RequestBody PropertyTypeModel propertyTypeModel)
    {
        return propertytypeservice.SavePropertyType(propertyTypeModel);
    }

    @PutMapping("/edit/{propertytypeId}")
    public ResponseEntity<ResponseResult> UpdatePropertyType(@PathVariable int propertytypeId, @RequestBody PropertyTypeModel propertyTypeModel)
    {
        return propertytypeservice.UpdatePropertyType(propertytypeId,propertyTypeModel);
    }

    @DeleteMapping("/delete/{propertytypeId}")
    public ResponseEntity<ResponseResult> DeletePropertyType(@PathVariable int propertytypeId)
    {
        return propertytypeservice.DeleteByIDPropertyType(propertytypeId);
    }
}
