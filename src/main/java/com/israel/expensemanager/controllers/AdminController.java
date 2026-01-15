package com.israel.expensemanager.controllers;

import com.israel.expensemanager.models.UserModel;
import com.israel.expensemanager.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{username}")
    public ResponseEntity<Void> deleteUser(@AuthenticationPrincipal UserModel user, @PathVariable  String userToDelete) {
        adminService.deleteUser(user.getId(), userToDelete);
        return ResponseEntity.noContent().build();
    }
}
