package com.israel.expensemanager.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ExpensesDTO(@NotBlank String expense,
                          @NotBlank BigDecimal price) {
}
