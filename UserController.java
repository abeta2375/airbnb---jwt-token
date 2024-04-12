package com.airbnb.controller;

import com.airbnb.dto.LoginDto;
import com.airbnb.dto.PropertyUserDto;
import com.airbnb.entity.PropertyUser;
import com.airbnb.service.PropertyUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private PropertyUserService propertyUserService;

    public UserController(PropertyUserService propertyUserService) {
        this.propertyUserService = propertyUserService;
    }

    //add user
    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody PropertyUserDto propertyUserDto){
        PropertyUser propertyUser = propertyUserService.addUser(propertyUserDto);

        if(propertyUser != null){
            return new ResponseEntity<>("Registration Successful", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //verify user
//    @PostMapping("/login")
//    public ResponseEntity<String> verifyLogin(@RequestBody LoginDto loginDto){
//        Boolean status = propertyUserService.verifyLogin(loginDto);
//
//        if(status){
//            return new ResponseEntity<>("User Signed in successfully", HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<String> verifyLogin(@RequestBody LoginDto loginDto){
        String token = propertyUserService.verifyLogin(loginDto);

        if(token!=null){
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
