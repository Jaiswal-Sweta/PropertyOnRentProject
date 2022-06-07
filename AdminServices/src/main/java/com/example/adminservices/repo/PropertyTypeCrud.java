package com.example.adminservices.repo;

import com.example.adminservices.model.PropertyTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyTypeCrud extends JpaRepository<PropertyTypeModel,Integer> {

}
