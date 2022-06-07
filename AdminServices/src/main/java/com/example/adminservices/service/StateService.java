package com.example.adminservices.service;

import com.example.adminservices.model.RequestModel.ResponseResult;
import com.example.adminservices.model.StateModel;
import com.example.adminservices.repo.StateCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    StateCrud statecrud;

    @Autowired
    ResponseResult responseResult;

    public ResponseEntity<ResponseResult> SaveState(StateModel statemodel) {
        try
        {
            statecrud.save(statemodel);
            responseResult = new ResponseResult(true,"State Added!");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseResult);
        } catch (Exception e)
        {
            responseResult = new ResponseResult(false,"This State not exist!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseResult);
        }
    }

    public ResponseEntity<ResponseResult> UpdateState(int ID,StateModel statemodel)
    {
        if(statecrud.findById(ID).isPresent())
        {
            statemodel.setState_id(ID);
            statecrud.save(statemodel);
            responseResult = new ResponseResult(true,"State Updated!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This State not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }

    public ResponseEntity<List<StateModel>> FindAllState() {
        try
        {
            List<StateModel> model= statecrud.findAll();
            responseResult = new ResponseResult(true,"All State");
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e)
        {
            responseResult = new ResponseResult(false,"No Records Found!");
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<ResponseResult> DeleteByIDState(int ID) {

        if(statecrud.findById(ID).isPresent()) {
            statecrud.deleteById(ID);
            responseResult = new ResponseResult(true,"State Deleted!");
            return ResponseEntity.ok(responseResult);
        }
        responseResult = new ResponseResult(false,"This State not exist!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseResult);
    }
}

