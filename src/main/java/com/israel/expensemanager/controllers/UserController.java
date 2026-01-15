package com.israel.expensemanager.controllers;

import com.israel.expensemanager.dtos.AuthenticationDTO;
import com.israel.expensemanager.models.UserModel;
import com.israel.expensemanager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/home")
public class UserController {
    private final UserService userService;

    @PatchMapping
    public ResponseEntity<UserModel> updateUser(@AuthenticationPrincipal UserModel user, @RequestBody AuthenticationDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user.getId(), data));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMyAccount(@AuthenticationPrincipal UserModel user, @RequestBody AuthenticationDTO data) {
        userService.deleteMyAccount(user.getId(), data);
        return ResponseEntity.noContent().build();
    }
}
