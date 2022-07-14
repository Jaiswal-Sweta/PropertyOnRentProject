package com.example.adminservices.controller;

import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.model.StateModel;
import com.example.adminservices.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "*")
public class StateController {

    @Autowired
    StateService stateservice;

    @PostMapping("/add")
    public ResponseEntity<ResponseResult> AddState(@RequestBody StateModel statemodel)
    {
        return stateservice.SaveState(statemodel);
    }

    @GetMapping("/get")
    public ResponseEntity<List<StateModel>> GetAllState()
    {
        return stateservice.FindAllState();
    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<ResponseResult> DeleteState(@PathVariable int ID) {return stateservice.DeleteByIDState(ID);}

    @PutMapping("/edit/{ID}")
    public ResponseEntity<ResponseResult> UpdateState(@PathVariable int ID, @RequestBody StateModel statemodel) { return stateservice.UpdateState(ID,statemodel);}

}
