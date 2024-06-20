package com.example.sportsscore.controller;

import com.example.sportsscore.model.User;
import com.example.sportsscore.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriberController {
    @Autowired
    SubscriberService subscriberService;

    @PostMapping("addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        try{
            return new ResponseEntity<>( subscriberService.addUser(user),HttpStatus.CREATED);
        }
        catch (Exception ex){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("deleteUser/{id}")
    public  ResponseEntity<User> deleteUser(@PathVariable int id){
        try{
            return new ResponseEntity<>( subscriberService.deleteUser(id),HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // add subscription
    // by team

}
