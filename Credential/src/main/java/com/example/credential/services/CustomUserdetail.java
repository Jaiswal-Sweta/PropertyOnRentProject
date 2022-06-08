package com.example.credential.services;

import com.example.credential.model.RegistrationModel;
import com.example.credential.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserdetail implements UserDetailsService {

    @Autowired
    private RegistrationRepo registrationRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailid) throws UsernameNotFoundException {
        RegistrationModel user = registrationRepo.findByEmailId(emailid);
        if (user != null) {
            System.out.println("User is "+user);
            return User.builder().username(user.getEmailId()).password(user.getPassword()).roles(user.getRoleModel().getRoleName()).build();
        } else {
            throw new UsernameNotFoundException("User not found..!");
        }
    }
}
