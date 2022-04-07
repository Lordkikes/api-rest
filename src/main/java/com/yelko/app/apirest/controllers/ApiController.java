package com.yelko.app.apirest.controllers;

import com.yelko.app.apirest.dto.UserRequest;
import com.yelko.app.apirest.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class ApiController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.usersService.findAll());
    }

    @GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByUsername(@PathVariable ("username") String username){
        return ResponseEntity.ok(this.usersService.findByUsername(username));
    }

    @GetMapping(value = "/username/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable ("id") Long id){
        return ResponseEntity.ok(this.usersService.findById(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUser(@RequestBody UserRequest request){

        this.usersService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);

    }
}
