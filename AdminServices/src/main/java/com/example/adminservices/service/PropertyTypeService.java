package com.example.adminservices.service;

import com.example.adminservices.model.PropertyTypeModel;
import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.repo.PropertyTypeCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyTypeService {

    @Autowired
    public  PropertyTypeCrud propertytypecrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<List<PropertyTypeModel>> FindAllPropertyType(){
        try
        {
            List<PropertyTypeModel> model= propertytypecrud.findAll();
            responseResult = new ResponseResult(true,"All Property");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<ResponseResult> SavePropertyType(PropertyTypeModel propertytypemodel)
    {
        try
        {
            propertytypecrud.save(propertytypemodel);
            responseResult = new ResponseResult(true,"Property Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,"Property Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdatePropertyType(int ID,PropertyTypeModel propertyTypeModel)
    {
        if(propertytypecrud.findById(ID).isPresent())
        {
            propertyTypeModel.setPropertytype_id(ID);
            propertytypecrud.save(propertyTypeModel);
            responseResult = new ResponseResult(true,"PropertyType Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This PropertyType not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> DeleteByIDPropertyType(int ID)
    {
        if(propertytypecrud.findById(ID).isPresent())
        {
            propertytypecrud.deleteById(ID);
            responseResult = new ResponseResult(true,"PropertyType Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This PropertyType not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

}
