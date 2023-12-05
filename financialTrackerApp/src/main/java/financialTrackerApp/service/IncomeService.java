package financialTrackerApp.service;

import financialTrackerApp.entity.Income;
import financialTrackerApp.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAllIncome(List<Long> incomeId) {
        return incomeRepository.findAllById(); //?
    }

    public Income getIncomeById(Long id) {
        return incomeRepository.findById(id).orElse(null);
    }

    public Income getIncomeByCategory(Long categoryId) {
        return incomeRepository.findById(Long categoryId); //?
    }

    public void saveIncome(Income income) {
        incomeRepository.save(income);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }

}
