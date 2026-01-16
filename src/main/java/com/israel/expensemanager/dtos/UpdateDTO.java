package com.israel.expensemanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateDTO(@NotBlank String expense,
                        @NotBlank BigDecimal price) {
}
