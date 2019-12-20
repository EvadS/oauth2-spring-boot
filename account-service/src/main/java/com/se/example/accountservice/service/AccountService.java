package com.se.example.accountservice.service;


import com.se.example.accountservice.dto.UserDto;
import com.se.example.accountservice.dto.UserRegistrationDto;

public interface AccountService {

    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    UserDto create(UserRegistrationDto user);
}