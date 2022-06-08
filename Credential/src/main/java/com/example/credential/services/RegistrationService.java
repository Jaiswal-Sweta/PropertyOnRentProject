package com.example.credential.services;

import com.example.credential.model.RegistrationModel;
import com.example.credential.model.ResponseData;
import com.example.credential.repo.RegistrationRepo;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    GenerateOTP generateOTP;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Qualifier("hazelcastInstance")
    @Autowired
    HazelcastInstance instance;

    RegistrationModel setRegistrationModel;

    private IMap<String, Integer> otpChache() {
        return instance.getMap("OTPMap");
    }

    public Iterable<RegistrationModel> getAllUser() {
        return registrationRepo.findAll();
    }

    public ResponseEntity<ResponseData> saveUser(RegistrationModel registrationModel) throws MessagingException, UnsupportedEncodingException {
        RegistrationModel registrationModelObject = registrationRepo.findByEmailId(registrationModel.getEmailId());
        if (registrationModelObject == null) {
            otpChache().set("OTPCode", generateOTP.sendVerificationEmail(registrationModel.getEmailId(), registrationModel.getFirstname() + " " + registrationModel.getLastname()));
            setRegistrationModel = registrationModel;
            return ResponseEntity.ok(new ResponseData(true, "OTP sent successfully..!"));
        }
        return ResponseEntity.badRequest().body(new ResponseData(false, "User Already Exist..!"));
    }

    public ResponseEntity<ResponseData> checkOTP(int getOTP) {
        if (getOTP == otpChache().get("OTPCode")) {
            setRegistrationModel.setPassword(passwordEncoder.encode(setRegistrationModel.getPassword()));
            System.out.println(setRegistrationModel);
            registrationRepo.save(setRegistrationModel);
            return ResponseEntity.ok(new ResponseData(true, "New User Added..!"));
        }
        return ResponseEntity.badRequest().body(new ResponseData(false, "OTP is Wrong..!"));
    }
}
