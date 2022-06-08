package com.example.userservice.services;

import com.example.userservice.client.Register;
import com.example.userservice.model.PropertyModel;
import com.example.userservice.model.RegistrationModel;
import com.example.userservice.model.ResponseData;
import com.example.userservice.repo.UserServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    Register register;

    @Autowired
    UserServiceRepo userServiceRepo;

    public ResponseEntity<ResponseData> saveUser(RegistrationModel registrationModel) {
        return register.addUser(registrationModel);
    }

    public List<RegistrationModel> getData() {
        return register.getAllUser();
    }

    public Iterable<PropertyModel> getCityWiseProperty(int cityId) {
        return userServiceRepo.findByCityModelCityId(cityId);
    }

    public Iterable<PropertyModel> findTypeWiseProperty(int propertyTypeId) {
        return userServiceRepo.findByProepertyTypePropertytypeName(propertyTypeId);
    }

    public Iterable<PropertyModel> findEventWiseProperty(int eventId) {
        return userServiceRepo.findByCityModelCityId(eventId);
    }
}
