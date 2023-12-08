package com.pingwit.financialTrackerApp.dto;

import com.pingwit.financialTrackerApp.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseConversionService {

    public ExpenseDTO convertToExpenseDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(expense.getId());
        expenseDTO.setDescription(expense.getDescription());
        expenseDTO.setAmount(expense.getAmount());
        // Category/Date ?
        return expenseDTO;
    }

    public List<ExpenseDTO> convertToExpenseDTOList(List<Expense> expenses) {
        return expenses.stream()
                .map(this::convertToExpenseDTO)
                .collect(Collectors.toList());
    }

    public Expense convertToExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense(description, amount, date);
        expense.setId(expenseDTO.getId());
        expense.setDescription(expenseDTO.getDescription());
        expense.setAmount(expenseDTO.getAmount());
        // Category/Date ?
        return expense;
    }
}

