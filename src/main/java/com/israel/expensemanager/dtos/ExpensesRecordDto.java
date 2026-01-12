package com.israel.expensemanager.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ExpensesRecordDto(UUID userId,
                                String expense,
                                BigDecimal price) {
}
