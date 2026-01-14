package com.israel.expensemanager.services;

import com.israel.expensemanager.dtos.ExpensesDTO;
import com.israel.expensemanager.models.ExpensesModel;
import com.israel.expensemanager.repositories.ExpensesRepository;
import com.israel.expensemanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ExpensesService {
    private final ExpensesRepository expensesRepository;
    private final UserRepository userRepository;

    @Transactional
    public ExpensesModel saveExpense(ExpensesDTO expensesDTO) {
        ExpensesModel expense = new ExpensesModel();
        expense.setExpense(expensesDTO.expense());
        expense.setPrice(expensesDTO.price());
        expense.setUser(userRepository.findById(expensesDTO.userId())
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

    @Transactional
    public ExpensesModel updateExpense(ExpensesDTO expensesDTO, UUID expenseId) {
        ExpensesModel expense = expensesRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("expense id not found"));

        expense.setExpense(expensesDTO.expense());
        expense.setPrice(expensesDTO.price());
        expense.setUser(userRepository.findById(expensesDTO.userId())
                .orElseThrow(() -> new RuntimeException("user not found")));

        return expensesRepository.save(expense);
    }

    //this make two access to the bank, later make a query in repository to use only 1 access use @transactional and @Modifying
    @Transactional
    public void deleteExpense(UUID expenseId, UUID loggedUserId) {
        ExpensesModel expense = expensesRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("expense id not found"));

        if(!expense.getUser().getId().equals(loggedUserId)) {
            throw new RuntimeException("you don't have access to this expense");
        }

        expensesRepository.deleteById(expenseId);
    }
}
