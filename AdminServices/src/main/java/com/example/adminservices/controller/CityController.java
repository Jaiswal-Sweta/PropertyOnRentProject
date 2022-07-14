package com.example.adminservices.controller;

import com.example.adminservices.model.CityModel;
import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityservice;

    @PostMapping("/add")
    public ResponseEntity<ResponseResult> AddCity(@RequestBody CityModel citymodel)
    {
        return cityservice.SaveCity(citymodel);
    }

    @PutMapping("/edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateCity(@PathVariable int ID, @RequestBody CityModel citymodel)
    {
        return cityservice.UpdateCity(ID,citymodel);
    }

    @GetMapping("/get")
    public ResponseEntity<List<CityModel>> GetAllCity()
    {
        return cityservice.FindAllCity();
    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteCity(@PathVariable int ID)
    {
        return cityservice.DeleteByIDCity(ID);
    }

    @GetMapping("/getcitystatewise/{ID}")
    public ResponseEntity<List<CityModel>> GetCityStatewise(@PathVariable int ID)
    {
        return cityservice.FindCityStatewise(ID);
    }
}

