package com.airbnb.service;

import com.airbnb.dto.LoginDto;
import com.airbnb.dto.PropertyUserDto;
import com.airbnb.entity.PropertyUser;

public interface PropertyUserService {

    //create User
    PropertyUser addUser(PropertyUserDto propertyUserDto);

    //verify user
    String verifyLogin(LoginDto loginDto);
}
