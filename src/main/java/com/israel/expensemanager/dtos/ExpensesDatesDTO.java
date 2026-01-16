package com.israel.expensemanager.dtos;

import java.time.LocalDateTime;

public record ExpensesDatesDTO(LocalDateTime beginDate,
                               LocalDateTime lastDate) {
}
