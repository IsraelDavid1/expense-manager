package com.israel.expensemanager.controllers;

import com.israel.expensemanager.dtos.UserRecordDto;
import com.israel.expensemanager.models.UserModel;
import com.israel.expensemanager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> createUser(@RequestBody UserRecordDto userRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRecordDto));
    }

}
