package com.example.userservice.repo;

import com.example.userservice.model.PropertyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceRepo extends JpaRepository<PropertyModel, Integer> {
    Iterable<PropertyModel> findByCityModelCityId(int cityId);

    Iterable<PropertyModel> findByProepertyTypePropertytypeName(int propertyTypeId);
}