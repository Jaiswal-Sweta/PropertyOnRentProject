package com.example.adminservices.service;

import com.example.adminservices.model.EventsModel;
import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.repo.EventsCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    EventsCrud eventscrud;

    @Autowired
    ResponseResult responseResult;
    public ResponseEntity<List<EventsModel>> FindALlEvents()
    {
        try
        {
            List<EventsModel> model= eventscrud.findAll();
            responseResult = new ResponseResult(true,"All Events");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,"No Records Found!");
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<ResponseResult> SaveEvents(EventsModel eventsModel)
    {
        try
        {
            eventscrud.save(eventsModel);
            responseResult = new ResponseResult(true,"Events Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,"Events Not Added!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateEvents(int ID,EventsModel eventsModel)
    {
        if(eventscrud.findById(ID).isPresent())
        {
            eventsModel.setEventsId(ID);
            eventscrud.save(eventsModel);
            responseResult = new ResponseResult(true,"Event Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This Event not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<ResponseResult> DeleteByIDEvents(int ID)
    {
        if(eventscrud.findById(ID).isPresent())
        {
            eventscrud.deleteById(ID);
            responseResult = new ResponseResult(true,"Event Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This Event not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }
}
