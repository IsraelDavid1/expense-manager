package com.israel.expensemanager.controllers;

import com.israel.expensemanager.dtos.ExpensesDTO;
import com.israel.expensemanager.dtos.ExpensesDatesDTO;
import com.israel.expensemanager.dtos.UpdateDTO;
import com.israel.expensemanager.models.ExpensesModel;
import com.israel.expensemanager.models.UserModel;
import com.israel.expensemanager.services.ExpensesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/expenses")
public class ExpensesController {
    private final ExpensesService expensesService;

    @PostMapping
    public ResponseEntity<ExpensesModel> saveExpense(@AuthenticationPrincipal UserModel user, @RequestBody @Valid ExpensesDTO data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expensesService.saveExpense(user.getId(), data));
    }

    @GetMapping
    public ResponseEntity<List<ExpensesModel>> getExpenses(@AuthenticationPrincipal UserModel user) {
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.getExpenses(user.getId()));
    }

    @GetMapping("/sum")
    public ResponseEntity<BigDecimal> sumExpenses(@AuthenticationPrincipal UserModel user) {
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.sumExpenses(user.getId()));
    }

    @GetMapping("/moneyleft")
    public ResponseEntity<BigDecimal> moneyLeft(@AuthenticationPrincipal UserModel user, @RequestParam BigDecimal userTotalMoney) {
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.moneyLeft(user.getId(), userTotalMoney));
    }

    @PostMapping("/date")
    public ResponseEntity<List<ExpensesModel>> findExpensesBetweenDates(@AuthenticationPrincipal UserModel user, @RequestBody @Valid ExpensesDatesDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.findExpensesBetweenDates(user.getId(), data));
    }

    @PatchMapping("/{oldExpense}")
    public ResponseEntity<ExpensesModel> updateExpense(@PathVariable UUID oldExpense, @AuthenticationPrincipal UserModel user,@RequestBody @Valid UpdateDTO data) {
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.updateExpense(oldExpense ,user.getId(), data));
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<Void> deleteExpense(@PathVariable UUID expenseId, @AuthenticationPrincipal UserModel user) {
        expensesService.deleteExpense(expenseId, user.getId());
        return ResponseEntity.noContent().build();
    }
}
