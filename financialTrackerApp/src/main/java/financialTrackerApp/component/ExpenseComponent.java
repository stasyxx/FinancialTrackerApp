package financialTrackerApp.component;

import financialTrackerApp.entity.Expense;
import financialTrackerApp.entity.enums.Category;
import financialTrackerApp.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseComponent {
    public ExpenseRepository expenseRepository;

    public BigDecimal calculateTotalExpensesByUserId(Long userId) {
        List<Expense> userExpenses = expenseRepository.findByUserId(userId);

        BigDecimal totalExpenses = BigDecimal.ZERO;

        for (Expense expense : userExpenses) {
            totalExpenses = totalExpenses.add(expense.getExpenseAmount());
        }

        return totalExpenses;
    }

    public BigDecimal calculateTotalExpenseByUserIdByCategory(Long userID, Category category) {
        List<Expense> userExpense = expenseRepository.findByUserIdAndCategory(userId, category);

        BigDecimal totalExpenseByUserIdByCategory = BigDecimal.ZERO;

        for(Expense expense : userExpense) {
            totalExpenseByUserIdByCategory = totalExpenseByUserIdByCategory.add(expense.getExpenseAmount());
        }

        return totalExpenseByUserIdByCategory;
    }


}
