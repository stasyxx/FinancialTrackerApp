package financialTrackerApp.service;

import ch.qos.logback.core.pattern.Converter;
import financialTrackerApp.dto.IncomeDTO;
import financialTrackerApp.entity.Income;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeConversionService extends Converter {

    public IncomeDTO convertToIncomeDTO(Income income) {
        IncomeDTO incomeDTO = new IncomeDTO();
        incomeDTO.setIncomeId(income.getIncomeId());
        incomeDTO.setIncomeDescription(income.getIncomeDescription());
        incomeDTO.setIncomeAmount(income.getIncomeAmount());
        // Category/Date ?
        return incomeDTO;
    }

    public List<IncomeDTO> convertToIncomeDTOList(List<Income> incomes) {
        return incomes.stream()
                .map(this::convertToIncomeDTO)
                .collect(Collectors.toList());
    }

    public Income convertToIncome(IncomeDTO incomeDTO) {
        Income income = new Income();
        income.setIncomeId(incomeDTO.getIncomeId());
        income.setIncomeDescription(incomeDTO.getIncomeDescription());
        income.setIncomeAmount(incomeDTO.getIncomeAmount());
        // Category/Date ?
        return income;
    }

    @Override
    public String convert(Object o) {
        return null;
    }
}