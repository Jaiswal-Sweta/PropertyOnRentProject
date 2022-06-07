package com.example.demo.repo;

import com.example.demo.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingCrud extends JpaRepository<BookingModel,Integer> {

}
