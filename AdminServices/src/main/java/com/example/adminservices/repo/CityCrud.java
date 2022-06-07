package com.example.adminservices.repo;

import com.example.adminservices.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityCrud extends JpaRepository<CityModel,Integer> {

    @Query(value = "select * from city where state_id = ? order by city_name ASC",nativeQuery = true)
    List<CityModel> FindCityStatewise(int StateID);
}
