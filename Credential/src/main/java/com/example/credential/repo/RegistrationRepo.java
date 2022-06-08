package com.example.credential.repo;

import com.example.credential.model.RegistrationModel;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<RegistrationModel, Integer> {

    RegistrationModel findByEmailIdAndPassword(String emailId, String password);

    RegistrationModel findByEmailId(String emailId);
}
