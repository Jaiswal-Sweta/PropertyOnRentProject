package com.example.userservice.client;

import com.example.userservice.model.RegistrationModel;
import com.example.userservice.model.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "registeruser", url = "http://localhost:8080/")
public interface Register {

    @PostMapping("registration/saveuser")
    ResponseEntity<ResponseData> addUser(RegistrationModel registrationModel);

    @GetMapping("registration/getalluser")
    List<RegistrationModel> getAllUser();
}
