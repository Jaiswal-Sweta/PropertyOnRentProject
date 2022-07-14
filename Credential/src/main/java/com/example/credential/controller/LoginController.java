package com.example.credential.controller;

import com.example.credential.model.*;
import com.example.credential.model.ResponseData;
import com.example.credential.model.UserProfile;
import com.example.credential.model.UserResponse;
import com.example.credential.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/profile/{email_id}")
    public ResponseEntity<UserProfile> getDetail(@PathVariable String email_id) {
        System.out.println(LocalTime.now());
        return loginService.getUserDetail(email_id);
    }

    @PostMapping("/check")
    public String chackAuth(@RequestBody RegistrationModel registrationModel) {
        return loginService.checkAuth(registrationModel) == null ? "Invalid" : "Valid";
    }

    @PostMapping("/authentication")
    public ResponseEntity<UserResponse> generateToken(@RequestBody RegistrationModel reg) throws Exception {
        System.out.println(reg);
        return loginService.tokenSet(reg);
    }

    @PutMapping("/changepassword/{email_id}")
    public ResponseEntity<ResponseData> ChangePassword(@PathVariable String email_id, @RequestParam String new_password) {
        return loginService.changePassword(email_id, new_password);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<ResponseData> updateUser(@PathVariable int id, @RequestBody RegistrationModel registrationModelObject) {
        return loginService.updateUser(id, registrationModelObject);
    }

    @GetMapping("/userRole")
    public String getDetailsRoleUser() {
        return "user";
    }

    @GetMapping("/vendorRole")
    public String getDetailsRoleVendor() {
        return "Vendor";
    }

    @GetMapping("/adminRole")
    public String getDetailsRoleAdmin() {
        return "admin";
    }
}
