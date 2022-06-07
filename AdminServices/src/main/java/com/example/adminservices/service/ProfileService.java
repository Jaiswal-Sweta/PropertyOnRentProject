package com.example.adminservices.service;

import com.example.adminservices.model.RegistrationModel;
import com.example.adminservices.model.RequestModel.ProfileModel;
import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    ProfileModel profilemodel;

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<ProfileModel> getProfile(int userid)
    {
        RegistrationModel registrationModel;
        if(registrationRepo.findById(userid).isPresent())
        {
            registrationModel = registrationRepo.getRegistration(userid);
            profilemodel = new ProfileModel(registrationModel.getRegistration_id(),
                    registrationModel.getFirstname(),
                    registrationModel.getLastname(),
                    registrationModel.getEmailid(),
                    registrationModel.getContactnumber(),
                    registrationModel.getCityModel().getCity_id(),
                    registrationModel.getCityModel().getCity_name(),
                    registrationModel.getCityModel().getStateModel().getState_id(),
                    registrationModel.getCityModel().getStateModel().getState_name(),
                    registrationModel.getPincode());
            responseResult = new ResponseResult(true,"Profile");
            return ResponseEntity.status(HttpStatus.OK).body(profilemodel);
        }
        responseResult = new ResponseResult(false,"No User Profile Found!");
        return ResponseEntity.notFound().build();
    }
}
















//
//            profilemodel.setRegistrationid(registrationModel.getRegistration_id());
//                    profilemodel.setFirstname(registrationModel.getFirstname());
//                    profilemodel.setLastname(registrationModel.getLastname());
//                    profilemodel.setEmailid(registrationModel.getEmailid());
//                    profilemodel.setContactnumber(registrationModel.getContactnumber());
//                    profilemodel.setCity_id(registrationModel.getCityModel().getCity_id());
//                    profilemodel.setCity_name(registrationModel.getCityModel().getCity_name());
//                    profilemodel.setState_id(registrationModel.getCityModel().getStateModel().getState_id());
//                    profilemodel.setState_name(registrationModel.getCityModel().getStateModel().getState_name());
//                    profilemodel.setPincode(registrationModel.getPincode());