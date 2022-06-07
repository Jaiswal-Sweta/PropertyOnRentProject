package com.example.VendorServices.repo;

import com.example.VendorServices.model.BookingModel;
import com.example.VendorServices.model.PropertyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingCrud extends JpaRepository<BookingModel,Integer> {

    @Query(value = "select p.* from property p,booking b where p.property_id = b.property_id and p.registration_id = ?1",nativeQuery = true)
    List<PropertyModel> findBookedListByPropertyWise(int registrationId);

    @Query(value = "select * from booking where registration_id = ?1",nativeQuery = true)
    List<BookingModel> findBookedList(int registrationId);


}
