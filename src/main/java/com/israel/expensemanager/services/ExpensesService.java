package com.israel.expensemanager.services;

import com.israel.expensemanager.dtos.ExpensesDTO;
import com.israel.expensemanager.dtos.ExpensesDatesDTO;
import com.israel.expensemanager.dtos.UpdateDTO;
import com.israel.expensemanager.exceptions.ExpenseIdNotFoundException;
import com.israel.expensemanager.exceptions.InvalidDateRangeException;
import com.israel.expensemanager.exceptions.UserNotFoundException;
import com.israel.expensemanager.models.ExpensesModel;
import com.israel.expensemanager.repositories.ExpensesRepository;
import com.israel.expensemanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ExpensesService {
    private final ExpensesRepository expensesRepository;
    private final UserRepository userRepository;

    @Transactional
    public ExpensesModel saveExpense(UUID loggedUserId, ExpensesDTO data) {
        ExpensesModel expense = new ExpensesModel();
        expense.setExpense(data.expense());
        expense.setPrice(data.price());
        expense.setUser(userRepository.findById(loggedUserId)
                        .orElseThrow(() -> new UserNotFoundException("user not found")));
        expense.setDate(LocalDateTime.now());

        return  expensesRepository.save(expense);
    }


    public List<ExpensesModel> getExpenses(UUID loggedUserId) {
        LocalDateTime thisMonth = LocalDateTime.now();
        LocalDateTime firstDay = thisMonth
                .with(TemporalAdjusters.firstDayOfMonth())
                .toLocalDate()
                .atStartOfDay();
        LocalDateTime lastDay = thisMonth
                .with(TemporalAdjusters.lastDayOfMonth())
                .toLocalDate()
                .atTime(23,59,59);

        return expensesRepository.findByMonth(loggedUserId, firstDay, lastDay);
    }


    public BigDecimal sumExpenses(UUID loggedUserId) {
        return expensesRepository.sumAllExpensesByUser(loggedUserId);
    }


    public BigDecimal moneyLeft(UUID loggedUserId, BigDecimal userTotalMoney) {
        BigDecimal totalExpenses = expensesRepository.sumAllExpensesByUser(loggedUserId);
        return userTotalMoney.subtract(totalExpenses);
    }


    public List<ExpensesModel> findExpensesBetweenDates(UUID loggedUserId, ExpensesDatesDTO data) {
        if(data.beginDate().isAfter(data.lastDate())) {
            throw new InvalidDateRangeException("invalid date range");
        }

        return expensesRepository.findByMonth(loggedUserId, data.beginDate(), data.lastDate());
    }

    @Transactional
    public ExpensesModel updateExpense(UUID oldExpense ,UUID loggedUserID,UpdateDTO data) {
        ExpensesModel expense = expensesRepository.findById(oldExpense)
                .orElseThrow(() -> new ExpenseIdNotFoundException("expense id not found"));

        if(!expense.getUser().getId().equals(loggedUserID)) {
            throw new AccessDeniedException("you don't have access to this expense");
        }

        expense.setExpense(data.expense());
        expense.setPrice(data.price());

        return expensesRepository.save(expense);
    }

    //this make two access to the bank, later make a query in repository to use only 1 access use @transactional and @Modifying
    @Transactional
    public void deleteExpense(UUID expenseId, UUID loggedUserId) {
        ExpensesModel expense = expensesRepository.findById(expenseId)
                .orElseThrow(() ->  new ExpenseIdNotFoundException("expense id not found"));

        if(!expense.getUser().getId().equals(loggedUserId)) {
            throw new org.springframework.security.access.AccessDeniedException("you don't have access to this expense");
        }

        expensesRepository.delete(expense);
    }
}
