package com.example.adminservices.controller;

import com.example.adminservices.model.RequestModel.ProfileModel;
import com.example.adminservices.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/Get/{userid}")
    public ResponseEntity<ProfileModel> getProfile(@PathVariable int userid)
    {
        return profileService.getProfile(userid);
    }
}
