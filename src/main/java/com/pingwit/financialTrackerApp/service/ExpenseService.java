package com.pingwit.financialTrackerApp.service;

import com.pingwit.financialTrackerApp.entity.Expense;
import com.pingwit.financialTrackerApp.exception.ExpenseExistsException;
import com.pingwit.financialTrackerApp.exception.ExpenseNotFoundException;
import com.pingwit.financialTrackerApp.repository.CategoryRepository;
import com.pingwit.financialTrackerApp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void addExpense(Expense expense) throws ExpenseExistsException {
        expenseRepository.save(expense);
    }

    public List<Object[]> getByDate(Date fromDate, Date tillDate) {
        return expenseRepository.getExpenseByDate(fromDate, tillDate);
    }

    public List<Object[]> getByCategory(String category) {
        Long categoryId = categoryRepository.getIdForCategory(category);
        return expenseRepository.getExpenseByCategory(categoryId);
    }

    public List<Object[]> getByCategoryAndDate(Date fromDate, Date tillDate, String category) {
        Long categoryId = categoryRepository.getIdForCategory(category);
        return expenseRepository.getExpenseByCategoryAndDate(fromDate, tillDate, categoryId);
    }

    public Expense getExpenseById(Long id) throws ExpenseNotFoundException {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (!expense.isPresent()) {
            throw new ExpenseNotFoundException("Expense does not exist...");
        }
        return expense.get();
    }

    public Expense findExpenseByName(String expense) throws ExpenseNotFoundException {
        Optional<Expense> findExpenseByName = expenseRepository.findExpenseByName(expense);

        if (findExpenseByName.isPresent()) {
            return findExpenseByName.get();
        } else {
            throw new ExpenseNotFoundException("Expense does not exist: " + expense);
        }
    }

    public void deleteExpenseById(Long expenseId) throws ExpenseNotFoundException {
        Optional<Expense> expense = expenseRepository.findById(expenseId);
        if (expense.isPresent()) {
            System.out.println("Deleting expense by Id: " + expenseId);
            expenseRepository.deleteExpenseById(expenseId);
        }
    }
}