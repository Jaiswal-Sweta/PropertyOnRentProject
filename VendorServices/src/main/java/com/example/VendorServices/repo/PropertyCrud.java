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

    @Query(value = "select * from property LIMIT 6",nativeQuery = true)
    List<PropertyModel> findHomeProperty();


    @Query(value = "select * from property ORDER BY  property_id DESC LIMIT 6",nativeQuery = true)
    List<PropertyModel> findLatestProperty();

    @Query(value = "select * from property where property_id=?1",nativeQuery = true)
    Iterable<PropertyModel> findDetailProperty(int id);

    @Query(value = "select * from property ORDER BY  price DESC",nativeQuery = true)
    List<PropertyModel> findPropertyHighToLowPrice();

    @Query(value = "select * from property ORDER BY  price ASC",nativeQuery = true)
    List<PropertyModel> findPropertyLowToHighPrice();

    @Query(value = "select * from property where propertytype_id=?1 and city_id=?2",nativeQuery = true)
    List<PropertyModel> findProperty(int propertytypeid,int cityid);

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
