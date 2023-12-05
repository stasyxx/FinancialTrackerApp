package financialTrackerApp.entity;

import financialTrackerApp.entity.enums.Sourse;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;
    private BigDecimal incomeAmount;
    private Sourse incomeSource;
    private String incomeDescription;
    private Date date;

    @ManyToOne
    private User user;
}
