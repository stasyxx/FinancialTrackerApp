package com.pingwit.financialTrackerApp.controller;

import com.pingwit.financialTrackerApp.entity.Category;
import com.pingwit.financialTrackerApp.entity.Expense;
import com.pingwit.financialTrackerApp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/user/{userId}/totalExpenses")
    public ResponseEntity<BigDecimal> getTotalExpensesByUserId(@PathVariable Long userId) {
        BigDecimal totalExpenses = expenseService.calculateTotalExpensesByUserId(userId);
        return new ResponseEntity<>(totalExpenses, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/category/{categoryId}/totalExpenses")
    public ResponseEntity<BigDecimal> getTotalExpensesByUserIdByCategory(@PathVariable Long userId, @PathVariable Category category) {
        BigDecimal totalExpenseByCategory = expenseService.calculateTotalExpenseByUserIdByCategory(userId, category);
        return new ResponseEntity<>(totalExpenseByCategory, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        expenseService.addOwnExpense(expense);
        return new ResponseEntity<>("Expense added successfully", HttpStatus.CREATED);
    }

}