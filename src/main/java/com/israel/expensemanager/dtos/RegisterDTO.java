package com.israel.expensemanager.dtos;

import com.israel.expensemanager.models.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterDTO(@NotBlank String name,
                          @NotBlank @Size(min = 8, max = 20) String password,
                          @NotNull UserRole role) {
}
