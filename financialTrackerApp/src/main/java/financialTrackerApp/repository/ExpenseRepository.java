package financialTrackerApp.repository;

import financialTrackerApp.entity.Expense;
import financialTrackerApp.entity.User;
import financialTrackerApp.entity.enums.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long> {

    List<Expense> findByUserId(Long userId);
    List<Expense> findByUserIdAndCategory(Long userId, Category category);
    List<Expense> findAllById(Long id);
    List<Expense> findAllExpensesByDateByUserId();
    List<Expense> findAllExpensesByDateFromToByUserId();
    List<Expense> findTopNByUserIdByDateDesc(int n);

        /* BigDecimal calculateTotalExpensesByUserId(Long userId);
         BigDecimal calculateTotalExpensesByUserIdByCategory(Long userId);

        List<Expense> findByCategory(String category);
        List<Expense> findAllExpensesByDateByUserId();
        List<Expense> findAllExpensesByDateFromToByUserId();
        List<Expense> findTopNByOrderByDateDesc(int n);

        */


}
