package com.pingwit.financialTrackerApp.api.dto;

import com.pingwit.financialTrackerApp.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseConversionService {

    public ExpenseDTO convertToExpenseDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(expense.getExpenseId());
        expenseDTO.setDescription(expense.getExpenseDescription());
        expenseDTO.setAmount(expense.getExpenseAmount());
        return expenseDTO;
    }

    public List<ExpenseDTO> convertToExpenseDTOList(List<Expense> expenses) {
        return expenses.stream()
                .map(this::convertToExpenseDTO)
                .collect(Collectors.toList());
    }

    public Expense convertToExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense(); // ???
        expense.setExpenseId(expenseDTO.getId());
        expense.setExpenseDescription(expenseDTO.getDescription());
        expense.setExpenseAmount(expenseDTO.getAmount());
        return expense;
    }
}

