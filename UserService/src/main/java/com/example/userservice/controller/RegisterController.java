package com.example.userservice.controller;

import com.example.userservice.model.PropertyModel;
import com.example.userservice.model.RegistrationModel;
import com.example.userservice.model.ResponseData;
import com.example.userservice.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<ResponseData> registerNewUser(@RequestBody RegistrationModel registrationModel) {
        return registerService.saveUser(registrationModel);
    }

    @GetMapping("/getUserData")
    public List<RegistrationModel> getUserData() {
        return registerService.getData();
    }

    @GetMapping("/getpropertybycity/{cityid}")
    public Iterable<PropertyModel> searchByCity(@PathVariable(name = "cityid") int cityId) {
        return registerService.getCityWiseProperty(cityId);
    }

    @GetMapping("/getpropertybytype/{propertytypeid}")
    public Iterable<PropertyModel> searchByProrperyType(@PathVariable(name = "propertytypeid") int prorertytypeId) {
        return registerService.findTypeWiseProperty(prorertytypeId);
    }

    @GetMapping("/getpropertybyevent/{eventid}")
    public Iterable<PropertyModel> searchByEvent(@PathVariable(name = "eventid") int eventId) {
        return registerService.findEventWiseProperty(eventId);
    }

}
