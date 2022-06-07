package com.example.adminservices.controller;

import com.example.adminservices.model.EventsModel;
import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventsService eventsservice;

    @GetMapping("/get")
    public ResponseEntity<List<EventsModel>> GetALlEvents()
    {
        return eventsservice.FindALlEvents();
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseResult> AddEvents(@RequestBody EventsModel eventsModel)
    {
        return  eventsservice.SaveEvents(eventsModel);
    }

    @PutMapping("/edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateEvents(@PathVariable int ID, @RequestBody EventsModel eventsModel)
    {
        return eventsservice.UpdateEvents(ID,eventsModel);
    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteEvents(@PathVariable int ID)
    {
        return eventsservice.DeleteByIDEvents(ID);
    }
}
