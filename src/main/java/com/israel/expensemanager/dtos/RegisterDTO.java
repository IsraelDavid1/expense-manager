package com.israel.expensemanager.dtos;

import com.israel.expensemanager.models.UserRole;

public record RegisterDTO(String name,
                          String password,
                          UserRole role) {
}
