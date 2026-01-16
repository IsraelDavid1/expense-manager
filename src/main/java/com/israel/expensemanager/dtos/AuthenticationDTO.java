package com.israel.expensemanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthenticationDTO(@NotBlank String name,
                                @NotBlank @Size(min = 8, max = 20) String password) {
}
