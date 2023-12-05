package financialTrackerApp.entity;

import lombok.Data;
import org.hibernate.criterion.IdentifierProjection;

import javax.persistence.*;

import static org.hibernate.criterion.Projections.id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @OneToMany
    private Expense expense;
    private Income income;

    public IdentifierProjection getId() {
        return id();
    }
}
