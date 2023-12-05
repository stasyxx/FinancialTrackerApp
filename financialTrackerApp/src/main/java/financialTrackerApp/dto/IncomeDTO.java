package financialTrackerApp.dto;

import java.math.BigDecimal;

public class IncomeDTO {
    private Long incomeId;
    private String incomeDescription;
    private BigDecimal incomeAmount;

    public IncomeDTO() {
    }

    public IncomeDTO(Long incomeId, String incomeDescription, BigDecimal incomeAmount) {
        this.incomeId = incomeId;
        this.incomeDescription = incomeDescription;
        this.incomeAmount = incomeAmount;
    }

    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }
}
