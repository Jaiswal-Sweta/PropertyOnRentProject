package com.example.demo.repo;

import com.example.demo.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingCrud extends JpaRepository<BookingModel,Integer> {

    @Query(value = "SELECT * FROM booking WHERE user_registration_id = ?1",nativeQuery = true)
    List<BookingModel> findBookedList(int userregistrationId);

}
