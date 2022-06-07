package com.example.VendorServices.repo;

//import com.example.VendorServices.model.PropertyAmenitiesModel;
import com.example.VendorServices.model.PropertyAmenitiesModel;
import com.example.VendorServices.model.PropertyModel;
import com.example.VendorServices.model.RequestModel.ResponseResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface PropertyCrud extends JpaRepository<PropertyModel,Integer> {

    @Query(value = "select count(property_amenities_id) from property_amenities where property_amenities_id = ?1",nativeQuery = true)
    int findByPropertyAmenitiesID(int propertyamenitiesId);

    @Transactional
    @Modifying
    @Query(value = "delete from property_amenities where property_amenities_id = ?1",nativeQuery = true)
    int deleteByPropertyAmenitiesID(int propertyamenitiesId);

    @Query(value = "select count(photo_id) from photo where photo_id = ?1",nativeQuery = true)
    int findByPropertyPhotoID(int photoId);

    @Transactional
    @Modifying
    @Query(value = "delete from photo where photo_id = ?1",nativeQuery = true)
    int deleteByPropertyPhotoID(int eventPackageId);

    @Query(value = "select count(event_package_id) from event_packages where event_package_id = ?1",nativeQuery = true)
    int findByPropertyEventPackageID(int eventPackageId);

    @Transactional
    @Modifying
    @Query(value = "delete from event_packages where event_package_id = ?1",nativeQuery = true)
    int deleteByPropertyEventPackageID(int eventPackageId);

    @Query(value = "select count(property_id) from property where property_id = ?1",nativeQuery = true)
    int findByPropertyID(int propertyId);

    @Transactional
    @Modifying
    @Query(value = "delete from property where property_id = ?1",nativeQuery = true)
    int deleteByPropertyID(int PropertyId);
}