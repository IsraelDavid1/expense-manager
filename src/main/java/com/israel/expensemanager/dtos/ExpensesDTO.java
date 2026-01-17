package com.israel.expensemanager.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ExpensesDTO(@NotBlank String expense,
                          @NotNull @Min(1) BigDecimal price) {
}
