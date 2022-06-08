package com.example.credential.services;

import com.example.credential.config.JwtUtill;
import com.example.credential.model.RegistrationModel;
import com.example.credential.model.ResponseData;
import com.example.credential.model.UserProfile;
import com.example.credential.model.UserResponse;
import com.example.credential.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserdetail customUserDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtill jwtUtill;

    public RegistrationModel checkAuth(RegistrationModel registrationModel) {
        return registrationRepo.findByEmailIdAndPassword(registrationModel.getEmailId(), registrationModel.getPassword());
    }

    public ResponseEntity<UserProfile> getUserDetail(String emailId) {
        try {
            RegistrationModel registrationModel = registrationRepo.findByEmailId(emailId);
            UserProfile userProfile = new UserProfile();
            userProfile.setEmailId(registrationModel.getEmailId());
            userProfile.setFirstName(registrationModel.getFirstname());
            userProfile.setLastName(registrationModel.getLastname());
            userProfile.setContactNumber(registrationModel.getContactNumber());
            userProfile.setCityName(registrationModel.getCityModel().getCityName());
            userProfile.setPincode(registrationModel.getPincode());
            userProfile.setStateName(registrationModel.getCityModel().getStateModel().getStateName());
            return ResponseEntity.status(HttpStatus.OK).body(userProfile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    public ResponseEntity<UserResponse> tokenSet(RegistrationModel reg) throws Exception {
        try {
            System.out.println(reg + " Login service");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reg.getEmailId(), reg.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID CREDENTIALS", e);
        }
        UserDetails u  = customUserDetailService.loadUserByUsername(reg.getEmailId());
        String token = jwtUtill.doGenerateToken(reg.getEmailId());
        return token.equals(null) ? ResponseEntity.status(HttpStatus.UNAUTHORIZED).build() : ResponseEntity.ok(new UserResponse(token, u.getUsername(),u.getAuthorities().toString()));
    }

    public ResponseEntity<ResponseData> changePassword(String emailId, String Password) {
        RegistrationModel registerObj = registrationRepo.findByEmailId(emailId);
        if (registerObj == null)
            return ResponseEntity.badRequest().body(new ResponseData(false, "EmaildId not Found..!"));
        else {
            registerObj.setPassword(passwordEncoder.encode(Password));
            registrationRepo.save(registerObj);
            return ResponseEntity.ok(new ResponseData(true, "Password has been Changed..!"));
        }
    }

    public ResponseEntity<ResponseData> updateUser(int registerationId, RegistrationModel regBodyObj) {
        RegistrationModel registerObj = registrationRepo.findById(registerationId).orElse(null);
        if (registerObj == null) return ResponseEntity.badRequest().body(new ResponseData(false, "Not Found..!"));
        else {
            registerObj.setCityModel(regBodyObj.getCityModel());
            registerObj.setContactNumber(regBodyObj.getContactNumber());
            registerObj.setEmailId(regBodyObj.getEmailId());
            registerObj.setFirstname(regBodyObj.getFirstname());
            registerObj.setPassword(passwordEncoder.encode(registerObj.getPassword()));
            registerObj.setLastname(regBodyObj.getLastname());
            registerObj.setPincode(regBodyObj.getPincode());
            registrationRepo.save(registerObj);
            return ResponseEntity.ok().body(new ResponseData(true, "Updated..!"));
        }
    }
}
