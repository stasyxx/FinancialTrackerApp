package financialTrackerApp.component;

import financialTrackerApp.entity.Income;
import financialTrackerApp.entity.enums.Category;
import financialTrackerApp.repository.IncomeRepository;

import java.math.BigDecimal;
import java.util.List;

public class IncomeComponent {
    public IncomeRepository incomeRepository;

    public BigDecimal calculateTotalIncomeByUserId(Long userId) {
        List<Income> userIncomes = incomeRepository.findByUserId(userId);

        BigDecimal totalIncomesByUserId = BigDecimal.ZERO;

        for (Income income : userIncomes) {
            totalIncomesByUserId = totalIncomesByUserId.add(income.getIncomeAmount());
        }

        return totalIncomesByUserId;
    }

    public BigDecimal calculateTotalIncomeByUserIdByCategory(Long userID, Category category) {
        List<Income> userIncome = incomeRepository.findByUserIdAndCategory(userId, category);

        BigDecimal totalIncomeByUserIdByCategory = BigDecimal.ZERO;

        for(Income income : userIncome) {
            totalIncomeByUserIdByCategory = totalIncomeByUserIdByCategory.add(income.getIncomeAmount());
        }

        return totalIncomeByUserIdByCategory;
    }
}
