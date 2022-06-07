package com.example.adminservices.repo;

import com.example.adminservices.model.AmenitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenitiesCrud extends JpaRepository<AmenitiesModel,Integer> {

}
