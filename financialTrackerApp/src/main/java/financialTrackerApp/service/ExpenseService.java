package financialTrackerApp.service;

import financialTrackerApp.entity.Expense;
import financialTrackerApp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses(List<Long> expenseId) {
        return expenseRepository.findAllById(Long expenseId); //?
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense getExpenseByCategory(Long categoryId) {
        return expenseRepository.findById(Long categoryId); //?
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

}