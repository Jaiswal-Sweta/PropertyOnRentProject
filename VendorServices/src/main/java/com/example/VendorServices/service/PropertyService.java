package com.example.VendorServices.service;

import com.example.VendorServices.model.PropertyModel;
import com.example.VendorServices.model.RequestModel.ResponseResult;
import com.example.VendorServices.repo.PropertyCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PropertyService {

    @Autowired
    PropertyCrud propertyCrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<List<PropertyModel>> findAllProperty() {
        try {
            List<PropertyModel> model = propertyCrud.findAll();
            responseResult = new ResponseResult(true, "All City");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        } catch (Exception e) {
            responseResult = new ResponseResult(false, "No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public PropertyModel saveProperty(PropertyModel propertyModel) {
        System.out.println("hello" + propertyModel);
        return propertyCrud.save(propertyModel);
    }

    public ResponseEntity updateProperty(PropertyModel propertyModel)
    {
        propertyModel.setPropertyId(propertyModel.getPropertyId());
        Optional<PropertyModel> model =propertyCrud.findById(propertyModel.getPropertyId());
        PropertyModel propertyModel1 = model.get();
        propertyModel1.setPropertyName(propertyModel.getPropertyName());
        propertyModel1.setAddress(propertyModel.getAddress());
        propertyModel1.setPincode(propertyModel.getPincode());
        propertyModel1.setArea(propertyModel.getArea());
        propertyModel1.setPrice(propertyModel.getPrice());
        propertyModel1.setDescription(propertyModel.getDescription());
        propertyModel1.setPolicy(propertyModel.getPolicy());
        propertyModel1.setPostedDate(propertyModel.getPostedDate());
        propertyModel1.setRegistrationModel(propertyModel.getRegistrationModel());
        propertyModel1.setPropertyTypeModel(propertyModel.getPropertyTypeModel());
        propertyModel1.setCityModel(propertyModel.getCityModel());
        try{
            propertyCrud.save(propertyModel1);
            responseResult = new ResponseResult(true,"Properties are updated!");
            return ResponseEntity.ok(responseResult);
        } catch(Exception e) {
            responseResult = new ResponseResult(false, "Not Updated!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
        }
    }


    public ResponseEntity updatePropertyPhoto(PropertyModel propertyModel)
    {
        propertyModel.setPropertyId(propertyModel.getPropertyId());
        Optional<PropertyModel> model =propertyCrud.findById(propertyModel.getPropertyId());
        PropertyModel propertyModel1 = model.get();
        propertyModel1.setPhotoModel(propertyModel.getPhotoModel());
        try{
            propertyCrud.save(propertyModel1);
            responseResult = new ResponseResult(true,"Photo of properties are updated!");
            return ResponseEntity.ok(responseResult);
        } catch(Exception e) {
            responseResult = new ResponseResult(false, "Not Updated!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
        }
    }


    public ResponseEntity updatePropertyAmenities(PropertyModel propertyModel)
    {
        propertyModel.setPropertyId(propertyModel.getPropertyId());
        Optional<PropertyModel> model =propertyCrud.findById(propertyModel.getPropertyId());
        PropertyModel propertyModel1 = model.get();
        propertyModel1.setPropertyAmenitiesModels(propertyModel.getPropertyAmenitiesModels());
        try{
            propertyCrud.save(propertyModel1);
            responseResult = new ResponseResult(true,"Amenities of properties are updated!");
            return ResponseEntity.ok(responseResult);
        } catch(Exception e) {
            responseResult = new ResponseResult(false, "Not Updated!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
        }
    }

    public ResponseEntity updateEventPackage(PropertyModel propertyModel)
    {
        propertyModel.setPropertyId(propertyModel.getPropertyId());
        Optional<PropertyModel> model =propertyCrud.findById(propertyModel.getPropertyId());
        PropertyModel propertyModel1 = model.get();
        propertyModel1.setEventPackagesModels(propertyModel.getEventPackagesModels());
        try{
            propertyCrud.save(propertyModel1);
            responseResult = new ResponseResult(true,"Event Packages Updated!");
            return ResponseEntity.ok(responseResult);
        } catch(Exception e) {
            responseResult = new ResponseResult(false, "Not Updated!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> deletePropertyAmenities(int propertyamenitiesId)
    {
          if(propertyCrud.findByPropertyAmenitiesID(propertyamenitiesId)!=0)
          {
            propertyCrud.deleteByPropertyAmenitiesID(propertyamenitiesId);
            responseResult = new ResponseResult(true,"This Property Amenities are Deleted!");
            return ResponseEntity.ok(responseResult);
          }
        responseResult = new ResponseResult(false,"This Property Amenities not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> deletePropertyPhoto(int photoId)
    {
        if(propertyCrud.findByPropertyPhotoID(photoId)!=0)
        {
            propertyCrud.deleteByPropertyPhotoID(photoId);
            responseResult = new ResponseResult(true,"This Property Photos are Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This Property Photos not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> deletePropertyEventPackage(int eventPackageId)
    {
        if(propertyCrud.findByPropertyEventPackageID(eventPackageId)!=0)
        {
            propertyCrud.deleteByPropertyEventPackageID(eventPackageId);
            responseResult = new ResponseResult(true,"This Event Packages are Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This Event Packages not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> deleteProperty(int propertyId)
    {
        if(propertyCrud.findByPropertyID(propertyId)!=0)
        {
            propertyCrud.deleteByPropertyID(propertyId);
            responseResult = new ResponseResult(true,"This Property are Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This Property not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }
}
