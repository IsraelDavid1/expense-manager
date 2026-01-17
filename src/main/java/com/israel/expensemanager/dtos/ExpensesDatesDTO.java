package com.israel.expensemanager.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ExpensesDatesDTO(@NotNull LocalDateTime beginDate,
                               @NotNull LocalDateTime lastDate) {
}
