package com.example.adminservices.repo;

import com.example.adminservices.model.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateCrud extends JpaRepository<StateModel,Integer> {

}
