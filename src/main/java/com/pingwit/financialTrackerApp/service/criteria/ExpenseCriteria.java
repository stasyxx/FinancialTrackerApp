package com.pingwit.financialTrackerApp.service.criteria;

import com.pingwit.financialTrackerApp.entity.Category;
import com.pingwit.financialTrackerApp.entity.Expense;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class ExpenseCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    public BigDecimal calculateTotalExpensesByUserId(Long userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> query = cb.createQuery(BigDecimal.class);

        Root<Expense> root = query.from(Expense.class);
        query.select(cb.sum(root.get("expenseAmount")));
        query.where(cb.equal(root.get("userId"), userId));

        return entityManager.createQuery(query).getSingleResult();
    }

    public BigDecimal calculateTotalExpenseByUserIdByCategory(Long userId, Category category) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BigDecimal> query = cb.createQuery(BigDecimal.class);

        Root<Expense> root = query.from(Expense.class);
        query.select(cb.sum(root.get("expenseAmount")));
        query.where(
                cb.equal(root.get("userId"), userId),
                cb.equal(root.get("category"), category)
        );
        return entityManager.createQuery(query).getSingleResult();
    }


}
