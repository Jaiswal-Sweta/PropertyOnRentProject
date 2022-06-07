package com.example.adminservices.service;

import com.example.adminservices.model.AmenitiesModel;
import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.repo.AmenitiesCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenitiesService {

    @Autowired
    AmenitiesCrud amenitiescrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<ResponseResult> SaveAmenities(AmenitiesModel amenitiesModel)
    {
        try{
            amenitiescrud.save(amenitiesModel);
            responseResult = new ResponseResult(true,"Amenities Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,"Amenities Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateAmenities(int AmenitiesID,AmenitiesModel amenitiesModel)
    {
        if(amenitiescrud.findById(AmenitiesID).isPresent())
        {
            amenitiesModel.setAmenitiesId(AmenitiesID);
            amenitiescrud.save(amenitiesModel);

            responseResult = new ResponseResult(true,"Amenities Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This amenities not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> DeleteByIDAmenities(int AmenitiesID)
    {
        if(amenitiescrud.findById(AmenitiesID).isPresent())
        {
            amenitiescrud.deleteById(AmenitiesID);
            responseResult = new ResponseResult(true,"Amenities Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This amenities not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<List<AmenitiesModel>> FindALlAmenities()
    {
        try
        {
            List<AmenitiesModel> model= amenitiescrud.findAll();
            responseResult = new ResponseResult(true,"All Amenities");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }
}
