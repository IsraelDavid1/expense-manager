package com.israel.expensemanager.controllers;

import com.israel.expensemanager.dtos.ExpensesRecordDto;
import com.israel.expensemanager.models.ExpensesModel;
import com.israel.expensemanager.services.ExpensesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class ExpensesController {
    private final ExpensesService expensesService;

    @PostMapping
    public ResponseEntity<ExpensesModel> saveExpense(@RequestBody ExpensesRecordDto expensesRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expensesService.saveExpense(expensesRecordDto));
    }

    @GetMapping("/sum")
    public ResponseEntity<BigDecimal> sumExpenses(@RequestParam UUID userId) {
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.sumExpenses(userId));
    }

    @GetMapping("/moneyleft")
    public ResponseEntity<BigDecimal> moneyLeft(@RequestParam UUID userId, @RequestParam BigDecimal userTotalMoney) {
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.moneyLeft(userId, userTotalMoney));
    }
}
