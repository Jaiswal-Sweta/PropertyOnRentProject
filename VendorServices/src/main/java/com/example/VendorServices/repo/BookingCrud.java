package com.example.VendorServices.repo;

import com.example.VendorServices.model.BookingModel;
import com.example.VendorServices.model.PropertyModel;
import com.example.VendorServices.model.RequestModel.ResponseBookingDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public interface BookingCrud extends JpaRepository<BookingModel,Integer> {
    
    @Query(value = "select p.* from property p,booking b where p.property_id = b.property_id and p.registration_id = ?1",nativeQuery = true)
    List<PropertyModel> findBookedListByPropertyWise(int registrationId);

    @Query(value = "SELECT * FROM booking WHERE property_id IN ( Select property_id FROM property WHERE registration_id = ?1 ) and is_active = 1",nativeQuery = true)
    List<BookingModel> findBookedList(int registrationId);

    @Query(value = "SELECT * FROM booking WHERE property_id =?1 and check_in >= ?2",nativeQuery = true)
    List<BookingModel> findBookedDate(int propertyId, LocalDate localDate);

}
