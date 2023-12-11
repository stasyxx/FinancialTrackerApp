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

import java.math.BigDecimal;
import java.util.List;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private ExpenseCriteria expenseCriteria;

    @GetMapping("/user/{userId}/total-expenses-by-id")
    public ResponseEntity<BigDecimal> getTotalExpensesByUserId(@PathVariable Long userId) {
        BigDecimal totalExpenses = expenseCriteria.calculateTotalExpensesByUserId(userId);
        return new ResponseEntity<>(totalExpenses, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/category/{categoryId}/totalExpensesByCategory")
    public ResponseEntity<BigDecimal> getTotalExpensesByUserIdByCategory(@PathVariable Long userId,
                                                                         @PathVariable Category category) {
        BigDecimal totalExpenseByCategory = expenseCriteria.calculateTotalExpenseByUserIdByCategory(userId, category);
        return new ResponseEntity<>(totalExpenseByCategory, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Add a new expense to the system.")
    public Expense addExpense(@RequestBody Expense expense) {
        try {
            expenseService.addExpense(expense);
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid date format, use YYYY-MM-DD format", e);
        } catch (ExpenseExistsException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage(), e);
        }
        return expense;
    }

    @DeleteMapping(path = "{expenseId}")
    public void deleteExpenseById(@PathVariable("expenseId") Long expenseId) {
        try {
            expenseService.deleteExpenseById(expenseId);
        } catch (ExpenseNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/findExpenseById")
    @ApiOperation("Returns expense by ID.")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        try {
            Expense expenseById = expenseService.getExpenseById(id);
            return ResponseEntity.ok(expenseById);
        } catch (ExpenseNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/findExpenseByName")
    @ApiOperation("Returns expenses by name.")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        try {
            Optional<Expense> expenseByName = Optional.ofNullable(expenseService.findExpenseByName(name));
            if (expenseByName.isPresent()) {
                return ResponseEntity.ok(expenseByName.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (ExpenseNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/allExpenses")
    @ApiOperation("Returns list of all expenses in the system.")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> allExpenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(allExpenses);
    }
}