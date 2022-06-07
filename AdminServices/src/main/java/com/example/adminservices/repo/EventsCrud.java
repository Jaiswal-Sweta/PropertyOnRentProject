package com.example.adminservices.repo;

import com.example.adminservices.model.EventsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsCrud extends JpaRepository<EventsModel,Integer> {

}
