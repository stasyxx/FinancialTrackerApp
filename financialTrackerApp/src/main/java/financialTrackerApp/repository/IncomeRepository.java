package financialTrackerApp.repository;

import financialTrackerApp.entity.Expense;
import financialTrackerApp.entity.Income;
import financialTrackerApp.entity.enums.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IncomeRepository extends PagingAndSortingRepository {

    List<Income> findByUserId(Long userId);
    List<Expense> findByUserIdAndCategory(Long UserId, Category category);
    List<Income> findByCategory(String category);
    List<Income> findAllById(Long id);
    List<Income> findAllIncomesByDateByUserId();
    List<Income> findAllIncomesByDateFromToByUserId();
    List<Income> findTopNByUserIdByDateDesc(int n);
}
