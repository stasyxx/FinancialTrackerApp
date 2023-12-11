package com.pingwit.financialTrackerApp.api.controller;

import com.pingwit.financialTrackerApp.entity.Category;
import com.pingwit.financialTrackerApp.entity.Expense;
import com.pingwit.financialTrackerApp.exception.ExpenseExistsException;
import com.pingwit.financialTrackerApp.exception.ExpenseNotFoundException;
import com.pingwit.financialTrackerApp.service.ExpenseService;
import com.pingwit.financialTrackerApp.service.criteria.ExpenseCriteria;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private ExpenseCriteria expenseCriteria;

    @GetMapping("/user/{userId}/totalExpenses")
    public ResponseEntity<BigDecimal> getTotalExpensesByUserId(@PathVariable Long userId) {
        BigDecimal totalExpenses = expenseCriteria.calculateTotalExpensesByUserId(userId);
        return new ResponseEntity<>(totalExpenses, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/category/{categoryId}/totalExpenses")
    public ResponseEntity<BigDecimal> getTotalExpensesByUserIdByCategory(@PathVariable Long userId, @PathVariable Category category) {
        BigDecimal totalExpenseByCategory = expenseCriteria.calculateTotalExpenseByUserIdByCategory(userId, category);
        return new ResponseEntity<>(totalExpenseByCategory, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Add a new expense to the system.")
    public Expense addExpense(@RequestBody Expense expense) {
        try {
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid date format, use YYYY-MM-DD format", e);
      //  } catch (ExpenseExistsException e) {
      //      throw new ResponseStatusException(
      //              HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }

    @DeleteMapping(path = "{expenseId}")
    public void deleteExpenseById(@PathVariable("expenseId") Long expenseId) {
        try {
            expenseService.deleteExpenseById(expenseId);
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Invalid date format, use YYYY-MM-DD format", e);
      //  } catch (ExpenseNotFoundException e) {
      //     throw new ResponseStatusException(
      //              HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}