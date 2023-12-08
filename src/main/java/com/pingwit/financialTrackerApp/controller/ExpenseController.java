package com.pingwit.financialTrackerApp.controller;

import com.pingwit.financialTrackerApp.entity.Category;
import com.pingwit.financialTrackerApp.entity.Expense;
import com.pingwit.financialTrackerApp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getAllExpensesByUserId(@PathVariable Long userId) {
        List<Expense> expenses = expenseService.calculateTotalExpensesByUserId(); // ??????
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@PathVariable Category category) {
        List<Expense> expenses = expenseService.calculateTotalExpenseByUserIdByCategory(); //???????
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        expenseService.addOwnExpense();
        return new ResponseEntity<>("Expense added successfully", HttpStatus.CREATED);
    }

}