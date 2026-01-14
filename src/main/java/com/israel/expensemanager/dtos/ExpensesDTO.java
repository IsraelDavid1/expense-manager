package com.israel.expensemanager.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ExpensesDTO(UUID userId,
                          String expense,
                          BigDecimal price) {
}
