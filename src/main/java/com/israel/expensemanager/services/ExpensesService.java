package com.israel.expensemanager.services;

import com.israel.expensemanager.dtos.ExpensesRecordDto;
import com.israel.expensemanager.models.ExpensesModel;
import com.israel.expensemanager.repositories.ExpensesRepository;
import com.israel.expensemanager.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ExpensesService {
    private final ExpensesRepository expensesRepository;
    private final UserRepository userRepository;

    @Transactional
    public ExpensesModel saveExpense(ExpensesRecordDto expensesRecordDto) {
        ExpensesModel expense = new ExpensesModel();
        expense.setExpense(expensesRecordDto.expense());
        expense.setPrice(expensesRecordDto.price());
        expense.setUser(userRepository.findById(expensesRecordDto.userId())
                        .orElseThrow(() -> new RuntimeException("user not found")));
        expense.setDate(LocalDateTime.now());

        return  expensesRepository.save(expense);
    }


    public BigDecimal sumExpenses(UUID userId) {
        return expensesRepository.sumAllExpensesByUser(userId);
    }


    public BigDecimal moneyLeft(UUID userId, BigDecimal userTotalMoney) {
        BigDecimal totalExpenses = expensesRepository.sumAllExpensesByUser(userId);
        return userTotalMoney.subtract(totalExpenses);
    }
}
