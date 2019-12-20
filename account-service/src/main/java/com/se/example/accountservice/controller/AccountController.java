package com.se.example.accountservice.controller;


import com.se.example.accountservice.service.AccountService;
import com.se.example.accountservice.dto.UserDto;
import com.se.example.accountservice.dto.UserRegistrationDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public UserDto createNewAccount(@RequestBody UserRegistrationDto user) {
        return accountService.create(user);
    }

}