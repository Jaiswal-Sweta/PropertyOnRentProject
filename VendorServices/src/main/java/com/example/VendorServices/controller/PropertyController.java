package com.example.VendorServices.controller;

import com.example.VendorServices.model.PropertyModel;
import com.example.VendorServices.model.RequestModel.ResponseResult;
import com.example.VendorServices.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/getall")
    public ResponseEntity<List<PropertyModel>> getAllProperty()
    {
        return propertyService.findAllProperty();
    }

    @GetMapping("/getall/{id}")
    public Iterable<PropertyModel> getDetailProperty(@PathVariable int id)
    {
        return propertyService.findDetailProperty(id);
    }

    @GetMapping("/get")
    public ResponseEntity<List<PropertyModel>> getHomeProperty()
    {
        return propertyService.findHomeProperty();
    }

    @GetMapping("/getlatestproperty")
    public ResponseEntity<List<PropertyModel>> getLatestProperty()
    {
        return propertyService.findLatestProperty();
    }

    @GetMapping("/getpropertypricewise/{optionvalue}")
    public ResponseEntity<List<PropertyModel>> getPropertyHighToLowPrice(@PathVariable int optionvalue)
    {
        return propertyService.findPropertyPricewise(optionvalue);
    }

    @GetMapping("/getproperty/{propertytypeid}/{cityid}")
    public ResponseEntity<List<PropertyModel>> getPropertyHighToLowPrice(@PathVariable int propertytypeid,@PathVariable int cityid)
    {
        return propertyService.findProperty(propertytypeid,cityid);
    }

    @PostMapping("/add")
    public PropertyModel addProperty(@RequestBody PropertyModel propertyModel)
    {
        return propertyService.saveProperty(propertyModel);
    }

    @PutMapping("/edit")
    public ResponseEntity editProperty(@RequestBody  PropertyModel propertyModel)
    {
        return propertyService.updateProperty(propertyModel);
    }

    @PutMapping("/photo/edit")
    public ResponseEntity editPropertyPhoto(@RequestBody  PropertyModel propertyModel)
    {
        return propertyService.updatePropertyPhoto(propertyModel);
    }

    @PutMapping("/amenities/edit")
    public ResponseEntity editPropertyAmenities(@RequestBody PropertyModel propertyModel)
    {
        return propertyService.updatePropertyAmenities(propertyModel);
    }

    @PutMapping("/eventpackage/edit")
    public ResponseEntity editEventPackage(@RequestBody PropertyModel propertyModel)
    {
        return propertyService.updateEventPackage(propertyModel);
    }

    @DeleteMapping("amenities/delete/{propertyamenitiesId}")
    public ResponseEntity<ResponseResult> deletePropertyAmenities(@PathVariable int propertyamenitiesId)
    {
        return propertyService.deletePropertyAmenities(propertyamenitiesId);
    }

    @DeleteMapping("photo/delete/{photoId}")
    public ResponseEntity<ResponseResult> deletePropertyPhoto(@PathVariable int photoId)
    {
        return propertyService.deletePropertyPhoto(photoId);
    }

    @DeleteMapping("eventpackage/delete/{eventPackageId}")
    public ResponseEntity<ResponseResult> deletePropertyEventPackages(@PathVariable int eventPackageId)
    {
        return propertyService.deletePropertyEventPackage(eventPackageId);
    }

    @DeleteMapping("/delete/{propertyId}")
    public ResponseEntity<ResponseResult> deleteProperty(@PathVariable int propertyId)
    {
        return propertyService.deleteProperty(propertyId);
    }
}
