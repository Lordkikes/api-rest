package com.yelko.app.apirest.controllers;

import com.yelko.app.apirest.dto.UserRequest;
import com.yelko.app.apirest.dto.UsersDTO;
import com.yelko.app.apirest.service.UsersService;
import com.yelko.app.apirest.utils.exceptions.ApiUnprocessableEntityException;
import com.yelko.app.apirest.validator.UsersValidator;
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

    @Autowired
    UsersValidator validator;

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
    public ResponseEntity<Object> saveUser(@RequestBody UserRequest request) throws ApiUnprocessableEntityException {

        this.validator.validator(request);
        this.usersService.save(request);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable ("id") Long id){
        usersService.deleteById(id);

        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserRequest request, @PathVariable ("id") Long id){

        usersService.update(request, id);
        return ResponseEntity.ok(Boolean.TRUE);

    }
}
